package org.example;


public class Main {
    public static void main(String[] args) {
        TimeDisplayThread timeThread = new TimeDisplayThread();
        MessageThread messageThread = new MessageThread();
        timeThread.start();
        messageThread.start();


        FizzBuzzMultithreaded fizzBuzzMultithreaded = new FizzBuzzMultithreaded(15);
        fizzBuzzMultithreaded.fizzbuzz();
        fizzBuzzMultithreaded.fizz();
        fizzBuzzMultithreaded.buzz();
        fizzBuzzMultithreaded.number();
    }
}
