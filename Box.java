package ru.geekbrains.Level_3.Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public Box(T... obj) {
        list = Arrays.asList(obj);
    }

    public Box() {
        list = new ArrayList<T>();
    }

    void add(T obj) {
        list.add(obj);
    }

    void info() {
        if (list.isEmpty()) {
            System.out.println("Коробка пустая");
        } else {
            System.out.println("В коробке находятся " + list.get(0).toString() + " - " + list.size());
        }
    }

    float getWeight() {
        if (list.isEmpty()) {
            return 0;
        } else {
            return list.size() * list.get(0).getWeight();
        }
    }

    boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }

    void move(Box<T> box) {
        box.getList().addAll(list);
        list.clear();
    }
}
