package ru.geekbrains.Level_3.Lesson_7;

import ru.geekbrains.Level_3.Lesson_7.Annotations.AfterSuite;
import ru.geekbrains.Level_3.Lesson_7.Annotations.BeforeSuite;
import ru.geekbrains.Level_3.Lesson_7.Annotations.TestSuite;

import java.lang.reflect.*;
import java.util.*;

public class Main {
    public static void start(Class<?> name) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object obj;
        Map<Method, Integer> map = new HashMap<>();
        Method[] methods = name.getDeclaredMethods();
        int beforeMethod = 0, afterMethod = 0;
        int priority;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeMethod++;
                if (beforeMethod > 1) throw new RuntimeException();

                else {
                    map.put(method, method.getAnnotation(BeforeSuite.class).priority());
                }
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                afterMethod++;
                if (afterMethod > 1) throw new RuntimeException();
                else {
                    map.put(method, method.getAnnotation(AfterSuite.class).priority());
                }
            } else if (method.isAnnotationPresent(TestSuite.class)) {
                priority = method.getAnnotation(TestSuite.class).priority();
                map.put(method, priority);
            }
        }
        obj = name.newInstance();
        for (Map.Entry<Method, Integer> entry : map.entrySet()) {
            entry.getKey().setAccessible(true);
            entry.getKey().invoke(obj);
        }


        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(methodIntegerEntry ->
                        System.out.println(methodIntegerEntry.getValue() + " " + methodIntegerEntry.getKey()));

    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        start(TestClass.class);
    }
}
