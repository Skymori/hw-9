package task2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateJson {
    public static boolean extractDataToList(File file, List<User> users){
        if (file.exists() && file.isFile()){
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                String line;
                while ((line = bufferedReader.readLine())!= null){
                    String[] parts = line.strip().split(" ");
                    users.add(new User(parts[0],Integer.parseInt(parts[1])));
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("Invalid path to file");
            return false;
        }
        return true;
    }


    public static void convertToJson(String pathToJson, File file, List<User> users) {
        File fileJson = new File(pathToJson);
        if (!file.exists()){
            file.getParentFile().mkdirs();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileJson))){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(users);
            bufferedWriter.write(json);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void createJsonFormat(String pathToStartFile, String pathToJsonFile) {
        File file = new File(pathToStartFile);
        List<User> users = new ArrayList<>();
        if (!extractDataToList(file,users))return;
        if (users.size()!=0){
            convertToJson(pathToJsonFile,file,users);
        }
    }
}
