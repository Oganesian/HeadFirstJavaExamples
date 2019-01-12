package CHAPTER_15;

import java.io.*;
import java.net.*;


public class DailyAdviceServer_C15 {
    String[] adviceList = {"Advice 1", "Advice 2", "Advice 3", "Advice 4"};

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            while(true){
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }
}
