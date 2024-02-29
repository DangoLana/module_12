package org.example;

public class MessageThread  extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Минуло 5 секунд");
        }
    }
}
