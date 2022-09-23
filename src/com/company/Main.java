package com.company;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread one = new Thread(() -> {
            try {
                while (true) {
                    counter.increment();
                    System.out.println("Thread increment: " + counter.value());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread two = new Thread(() -> {
            try {
                while (true) {
                    counter.decrement();
                    System.out.println("Thread decrement: " + counter.value());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        one.start();
        two.start();
    }
}