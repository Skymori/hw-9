package task3;

import java.io.*;
import java.util.*;

public class FrequencyWords {
    public static String[] readTextFile(File file, StringBuilder stringBuilder){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line= bufferedReader.readLine()) !=null){
                stringBuilder.append(line.strip());
                stringBuilder.append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text = stringBuilder.toString();
        text = text.replaceAll("\\s+", " ");
        return text.split(" ");
    }
    public static List<Map.Entry<String,Integer>> createFrequencyWordsOfArray(String[] parts){
        Map<String, Integer> wordsCount = new HashMap<>();
        Set<String> wordsSet = new HashSet<>();
        List<String> allWords = new ArrayList<>(Arrays.asList(parts));
        for (String part : parts){
            if (!wordsSet.contains(part)){
                wordsSet.add(part);
                wordsCount.put(part,Collections.frequency(allWords,part));
            }
        }
        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(wordsCount.entrySet());
        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return entryList;
    }

    public static void findFrequencyInFile(String path) {
        File file = new File(path);
        StringBuilder stringBuilder = new StringBuilder();
        if (file.exists()&&file.isFile()){
            String[] parts = readTextFile(file, stringBuilder);
            List<Map.Entry<String,Integer>> entryList = createFrequencyWordsOfArray(parts);
            entryList.forEach(entry -> System.out.println(entry.getKey()+" "+entry.getValue()));
        }
        else {
            System.out.println("Error part file");
        }
    }
}
