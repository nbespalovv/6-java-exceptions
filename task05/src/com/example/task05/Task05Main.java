package com.example.task05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task05Main {
    public static void main(String[] args) {
        String pathToFile = args[0]; // "/home/user/file.txt"

        String s = null;
        try {
            s = readFile(pathToFile);
        } catch (FileNotFoundException e) {
            System.out.println(String.format("файл %s не найден", pathToFile));
        } catch (IOException e) {
            System.out.println(String.format("произошла ошибка при чтении файла %s", pathToFile));
        }
        System.out.println(s);
    }

    public static String readFile(String pathToFile) throws IOException {
        FileReader fileReader = new FileReader(pathToFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            stringBuilder.append(currentLine);
            stringBuilder.append("\n");
        }
        bufferedReader.close();

        return stringBuilder.toString();
    }
}