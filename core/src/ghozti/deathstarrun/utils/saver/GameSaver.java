package ghozti.deathstarrun.utils.saver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GameSaver {

    public static void createFile(String fileName){
        try {
            File fileCreated = new File(fileName);
            if (fileCreated.exists()){
                return;
            }
            if (fileCreated.createNewFile()){
                System.out.println("File created: " + fileName);
            }
        }catch (IOException e){
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }

    public static void saveToFile(String filePath, String content) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(content + "\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }

}
