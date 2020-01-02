package ru.siksmfp.java.patterns.creational.builder;

public class SecondBuilder implements Builder {
    private final String one;
    private final String two;
    private final String three;

    public SecondBuilder(String one, String two, String three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    @Override
    public PartOne getPartOne() {
        return new PartOne(one);
    }

    @Override
    public PartTwo getPartTwo() {
        return new PartTwo(two);
    }

    @Override
    public PartThree getPartThree() {
        return new PartThree(three);
    }
}
