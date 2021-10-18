package ru.geekbrains.Level_3.Lesson_4;

public class WaitNotifyClass {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        WaitNotifyClass waitNotifyObj = new WaitNotifyClass();
        Thread thread1 = new Thread(() -> {
            waitNotifyObj.printLetter('A', 'B');
        });
        Thread thread2 = new Thread(() -> {
            waitNotifyObj.printLetter('B', 'C');
        });
        Thread thread3 = new Thread(() -> {
            waitNotifyObj.printLetter('C', 'A');
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void printLetter(char current, char next) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != current) {
                        mon.wait();
                    }
                    System.out.print(current);
                    currentLetter = next;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
