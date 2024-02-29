package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TimeDisplayThread timeThread = new TimeDisplayThread();
        MessageThread messageThread = new MessageThread();

        timeThread.start();
        messageThread.start();

        FizzBuzzMultithreaded fizzBuzz = new FizzBuzzMultithreaded(15);

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        executor.submit(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        executor.submit(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        executor.submit(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        for (int i = 1; i <= 15; i++) {
            try {
                String output = fizzBuzz.takeFromQueueD();
                System.out.println(output);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        executor.shutdown();
    }
        }
