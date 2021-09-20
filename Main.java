package ru.geekbrains.Level_3.Lesson_1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

	    Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println("1.Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)\n" +
                "Исходный массив:");
        System.out.println(Arrays.toString(array));
        swap(array, 0, 9);
        System.out.println("Массив после смены значений первого и последнего индексов:");
        System.out.println(Arrays.toString(array));

        System.out.println("2.Написать метод, который преобразует массив в ArrayList");
        List<Integer> list = convertToList(array);
        System.out.println(list.getClass() + " : " + list);

        System.out.println("3.Большая задача с коробками и фруктами");
        Apple apple = new Apple();
        Orange orange = new Orange();

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        for (int i = 0; i < 5; i++) {
            appleBox1.add(new Apple());
            orangeBox.add(new Orange());
            appleBox2.add(new Apple());
            appleBox2.add(new Apple());
        }

        appleBox1.info();
        appleBox2.info();
        orangeBox.info();

        System.out.println("Вес яблок в первой коробке - " + appleBox1.getWeight());
        System.out.println("Вес яблок во второй коробке - " + appleBox2.getWeight());
        System.out.println("Вес апельсинов в коробке - " + orangeBox.getWeight());

        System.out.println("Сравнение 'яблочной' и 'апельсиновой' коробок: " + appleBox1.compare(orangeBox));

        System.out.println("Содержимое коробок после пересыпания:");
        appleBox1.move(appleBox2);
        appleBox1.info();
        appleBox2.info();
    }
    public static void swap(Integer[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    private static <E> List<E> convertToList(E[] array) {
        return Arrays.asList(array);
    }
}
