import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadAFile_C14 {
    public void go() {
        try {
            File file = new File("MyFile.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;

            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
