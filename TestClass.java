package ru.geekbrains.Level_3.Lesson_7;

import ru.geekbrains.Level_3.Lesson_7.Annotations.AfterSuite;
import ru.geekbrains.Level_3.Lesson_7.Annotations.BeforeSuite;
import ru.geekbrains.Level_3.Lesson_7.Annotations.TestSuite;

public class TestClass {

    @BeforeSuite(priority = 0)
    public void methodBefore() {
        System.out.println("methodBefore");
    }


    @TestSuite(priority = 1)
    public void methodTest1() {
        System.out.println("methodTest1");
    }

    @TestSuite(priority = 5)
    public void methodTest2() {
        System.out.println("methodTest2");
    }

    @AfterSuite(priority = 10)
    public void methodAfter() {
        System.out.println("methodAfter");
    }
}
