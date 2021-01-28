package ru.siksmfp.java.patterns.behaviour.observer;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var subject = new DataSubject();

        var observer1 = new LessThanTenObserver("Less than 10", subject);
        var observer2 = new EvenObserver("Even", subject);

        IntStream.range(0, 20).forEach(subject::notify);
    }
}
