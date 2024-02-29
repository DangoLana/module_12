package org.example;

public class TimeDisplayThread extends Thread {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (true) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("Пройшло часу: " + (elapsedTime / 1000) + " секунд");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
