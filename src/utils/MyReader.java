package utils;


import model.TaskModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Random;

import java.util.HashMap;
import java.util.Map;

public class MyReader {
    private Map<String, TaskModel> lineMap;

    public MyReader(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("_", 5);
                if (parts.length >= 5) {
                    String id = parts[0].trim();
                    String titre = parts[1].trim();
                    String description = parts[2].trim();
                    String dateEchance = parts[3].trim();
                    String priorite = parts[4].trim();
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

