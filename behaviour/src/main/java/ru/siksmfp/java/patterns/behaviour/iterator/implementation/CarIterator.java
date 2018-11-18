package ru.siksmfp.java.patterns.behaviour.iterator.implementation;

public class CarIterator implements Iterable<Car> {
    private Car[] cars;
    private int currentPosition;

    public CarIterator(Car... cars) {
        this.cars = cars;
        this.currentPosition = 0;
    }

    @Override
    public Car next() {
        if (currentPosition < cars.length) {
            return cars[currentPosition++];
        } else {
            throw new IllegalArgumentException("Position is not correct");
        }
    }

    @Override
    public boolean hasNext() {
        return currentPosition < cars.length;
    }

    @Override
    public Car get(int i) {
        if (i < 0 || i >= cars.length) {
            throw new IllegalArgumentException("Position is not correct");
        }
        return cars[i];
    }
}
