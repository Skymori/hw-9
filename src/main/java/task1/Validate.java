package task1;

import java.io.*;
import java.util.regex.Pattern;

public class Validate {
    public static void ValidateNumber(String path) {
        File file = new File(path);
        String valid1 = "^\\d{3}-\\d{3}-\\d{4}$";
        String valid2 = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";
        if (file.exists() && file.isFile()){
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    if (Pattern.matches(valid1,line)|| Pattern.matches(valid2,line)){
                        System.out.println(line);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
