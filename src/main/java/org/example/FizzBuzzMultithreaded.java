package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzMultithreaded {
    private int n;
    private BlockingQueue<String> queueA = new LinkedBlockingQueue<>();
    private BlockingQueue<String> queueB = new LinkedBlockingQueue<>();
    private BlockingQueue<String> queueC = new LinkedBlockingQueue<>();
    private BlockingQueue<String> queueD = new LinkedBlockingQueue<>();

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    public void fizz() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                queueD.put("fizz");
            } else {
                queueD.put(String.valueOf(i));
            }
        }
    }

    public void buzz() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                queueD.put("buzz");
            } else {
                queueD.put(String.valueOf(i));
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                queueD.put("fizzbuzz");
            } else {
                queueD.put(String.valueOf(i));
            }
        }
    }

    public void number() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                queueD.put(String.valueOf(i));
            }
        }
    }
    public String takeFromQueueD() throws InterruptedException {
        return queueD.take();
    }
}
