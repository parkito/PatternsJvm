package ru.siksmfp.java.patterns.behaviour.iterator.implementation;

public class Main {
    public static void main(String[] args) {
        CarIterator carIterator = new CarIterator(new Car("1", 1.1), new Car("2", 2.2), new Car("3", 3.3));

        while (carIterator.hasNext()) {
            System.out.println(carIterator.next());
        }
    }
}
