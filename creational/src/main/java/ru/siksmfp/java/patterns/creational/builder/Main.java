package ru.siksmfp.java.patterns.creational.builder;

public class Main {

    public static void main(String[] args) {
        Builder builder1 = new FirstBuilder("One", "Two", "Three");
        Builder builder2 = new SecondBuilder("One", "Two", "Three");

        Director director1 = new Director(builder1);
        Director director2 = new Director(builder1);

        ComplexObject complexObject1 = director1.constructComplex();
        ComplexObject complexObject2 = director2.constructComplex();
    }
}
