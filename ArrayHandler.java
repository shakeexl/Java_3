package ru.geekbrains.Level_3.Lesson_6.ArrayHandler;

import java.util.ArrayList;
import java.util.List;

public class ArrayHandler {

    public static List<Integer> arrayHandler(ArrayList<Integer> list) {
        int indexOfLastFour = list.lastIndexOf(4) + 1;
        if (indexOfLastFour != 0) {return list.subList(indexOfLastFour, list.size());}
        else {throw new RuntimeException();}
    }

    public static boolean anotherArrayHandler(ArrayList<Integer> list) {
        boolean one = false;
        boolean four = false;
        for (int i: list) {
            if (i != 1 && i!=4) return false;
            if (i == 1) one = true;
            if (i == 4) four = true;
        }
        return one && four;
    }
}
