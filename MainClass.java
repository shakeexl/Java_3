package ru.geekbrains.Level_3.Lesson_5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    static final int CARS_COUNT = 4;
    static final CountDownLatch countDownLatchFinish = new CountDownLatch(CARS_COUNT);
    static final CountDownLatch countDownLatchReady = new CountDownLatch(CARS_COUNT);
    static final CyclicBarrier startBarrier = new CyclicBarrier(CARS_COUNT);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(80), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            final int randomSpeed = 20 + (int) (Math.random() * 10);
            cars[i] = new Car(race, randomSpeed);
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        countDownLatchReady.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        countDownLatchFinish.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}