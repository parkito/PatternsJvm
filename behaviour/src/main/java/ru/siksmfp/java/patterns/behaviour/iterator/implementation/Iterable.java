package ru.siksmfp.java.patterns.behaviour.iterator.implementation;

public interface Iterable<T> {

    T next();

    boolean hasNext();

    T get(int i);
}
