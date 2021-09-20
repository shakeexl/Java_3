package ru.geekbrains.Level_3.Lesson_2;

/*
Создать CRUD операции, 1 метод создани таблицы 2 метод для добавления записи 3 метод для получения записи 4 метод для удаления записи 5 удаление таблицы
 */

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        connect();

        createTable();
        addData();
        getData();
        deleteData();
        deleteTable();

        disconnect();
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            stmt = connection.createStatement();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createTable() {
        try {
            stmt.executeUpdate("CREATE TABLE students_test (\n" +
                    "    id    INTEGER PRIMARY KEY,\n" +
                    "    name  TEXT,\n" +
                    "    score INTEGER,\n" +
                    "    email TEXT\n" +
                    ");");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addData() {
        try {
            stmt.executeUpdate("INSERT INTO students_test (id, name, score, email) values (1, 'John', 67, 'john@gmail.com')");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void getData() {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_test");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteData() {
        try {
            stmt.executeUpdate("DELETE FROM students where id = 1");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteTable() {
        try {
            stmt.executeUpdate("DROP TABLE students_test");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
