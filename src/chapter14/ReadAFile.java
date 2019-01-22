package chapter14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadAFile {
    public void go() {
        try {
            File file = new File("MyFile_C14.txt");
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
