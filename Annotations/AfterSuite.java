package ru.geekbrains.Level_3.Lesson_7.Annotations;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface AfterSuite {
    int priority();
}
