package task2;

import java.io.*;

public class Main {
    public static final String PATH_TASK2 = "src/main/resources/FileTask2/file.TXT";
    public static final String PATH_TASK2JSON = "src/main/resources/FileTask2/user.json";

    public static void main(String[] args) {
        CreateJson.createJsonFormat(PATH_TASK2,PATH_TASK2JSON);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TASK2JSON)))
        {
            String line;
            while ((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
