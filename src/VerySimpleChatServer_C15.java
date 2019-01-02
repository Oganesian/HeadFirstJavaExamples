import java.io.*;
import java.net.*;
import java.util.*;

public class VerySimpleChatServer_C15 {
    ArrayList clientOutputStreams;

    public class ClientHanlder implements Runnable {
        BufferedReader reader;
        Socket socket;

        public ClientHanlder(Socket clientSocket){
            try {
                socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (Exception ex) {ex.printStackTrace();}
        }

        public void run(){
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    sendEveryone(message);
                }
            } catch (Exception ex) {ex.printStackTrace();}
        }
    }

    public static void main(String[] args){
        new VerySimpleChatServer_C15().go();
    }

    public void go() {
        clientOutputStreams = new ArrayList();
        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            while(true){
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                Thread t = new Thread(new ClientHanlder(clientSocket));
                t.start();
                System.out.println("got a connection");
            }
        } catch (Exception ex) {ex.printStackTrace();}
    }

    public void sendEveryone(String message) {
        Iterator iterator = clientOutputStreams.iterator();
        while (iterator.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter) iterator.next();
                writer.println(message);
                writer.flush();
            } catch (Exception ex) {ex.printStackTrace();}
        }
    }
}
