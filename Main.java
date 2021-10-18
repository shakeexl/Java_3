package ru.geekbrains.Level_3.Lesson_3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static ru.geekbrains.Level_3.Lesson_3.MergeFiles.MergeFilesMethod;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println(Arrays.toString(FileToArray("FilesForTask/FirstFile.txt")));

        MergeFilesMethod(
                "FilesForTask/FirstFile.txt", "FilesForTask/SecondFile.txt",
                "FilesForTask/ThirdFile.txt", "FilesForTask/FourthFile.txt",
                "FilesForTask/FifthFile.txt", "FilesForTask/Merge.txt");

        double StartTime = System.currentTimeMillis();
        BigFileReader.Reader("FilesForTask/BigFile.txt",88);
        System.out.println((System.currentTimeMillis()-StartTime)/1000 + " seconds");
    }

    public static byte[] FileToArray (String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }
}