package ru.geekbrains.Level_3.Lesson_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeFiles {
    public static void MergeFilesMethod (
            String firstPath, String secondPath, String thirdPath, String fourthPath, String fifthPath, String mergePath) throws IOException {

        String[] Paths = new String[]{firstPath, secondPath, thirdPath, fourthPath, fifthPath};

        PrintWriter pw = new PrintWriter(mergePath);
        BufferedReader br = new BufferedReader(new FileReader(firstPath));

        for (String path : Paths){
            ReadWrite(path, pw, br);
        }

        pw.flush();
        br.close();
        pw.close();
        System.out.println("Merged all files into Merge.txt");
    }

    public static void ReadWrite (String path, PrintWriter pw, BufferedReader br) throws IOException {
        br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        while (line != null)
        {
            pw.println(line);
            line = br.readLine();
        }
    }
}
