package ru.siksmfp.java.patterns.creational.builder;

public class Director {

    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public ComplexObject constructComplex() {
        ComplexObject complexObject = new ComplexObject();
        complexObject.setPartOne(builder.getPartOne());
        complexObject.setPartTwo(builder.getPartTwo());
        complexObject.setPartThree(builder.getPartThree());
        return complexObject;
    }
}
