package org.example;


public class FizzBuzzMultithreaded {
    private int n;
    private int current = 1;
    private final Object lock = new Object();

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    public void fizzbuzz() {
        new Thread(() -> {
            try {
                for (int i = 1; i <= n; i++) {
                    synchronized (lock) {
                        while (current <= n && (current % 3 != 0 || current % 5 != 0)) {
                            lock.wait();
                        }
                        if (current <= n) {
                            System.out.println("fizzbuzz");
                            current++;
                            lock.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void fizz() {
        new Thread(() -> {
            try {
                for (int i = 1; i <= n; i++) {
                    synchronized (lock) {
                        while (current <= n && (current % 3 != 0 || current % 5 == 0)) {
                            lock.wait();
                        }
                        if (current <= n) {
                            System.out.println("fizz");
                            current++;
                            lock.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void buzz() {
        new Thread(() -> {
            try {
                for (int i = 1; i <= n; i++) {
                    synchronized (lock) {
                        while (current <= n && (current % 5 != 0 || current % 3 == 0)) {
                            lock.wait();
                        }
                        if (current <= n) {
                            System.out.println("buzz");
                            current++;
                            lock.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void number() {
        new Thread(() -> {
            try {
                for (int i = 1; i <= n; i++) {
                    synchronized (lock) {
                        while (current <= n && (current % 3 == 0 || current % 5 == 0)) {
                            lock.wait();
                        }
                        if (current <= n) {
                            System.out.println(current);
                            current++;
                            lock.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}