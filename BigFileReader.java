package ru.geekbrains.Level_3.Lesson_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BigFileReader {
    //    public static void Reader(String path) throws Exception {
//        File file = new File(path);
//        FileInputStream fis = new FileInputStream(file);
//        byte[] byteArray = new byte[(int) file.length()];
//
//        fis.read(byteArray);
//        String data = new String(byteArray);
//    }
    public static void Reader(String path, int page) {
        try (RandomAccessFile raf = new RandomAccessFile(path, "r")) {
            raf.seek((page -1) * 1800);
            while (raf.getFilePointer() <= (page*1800)) {
                System.out.print((char) raf.read());
            }
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}