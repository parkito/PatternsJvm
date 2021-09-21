package com.siksmfp.creational.proxy.dynamic;

public class Company {
    // set in constructor ...
    private final MoralFibre moralFibre;
    private final String name;
    private final int i;
    private int cash;

    public Company(String name, int i, MoralFibre virtual) {
        this.name = name;
        this.i = i;
        moralFibre = virtual;
    }

    public void makeMoney() {
        cash++;
    }

    public void damageEnvironment() {
    }

    public void becomeFocusOfMediaAttention() {
        System.out.println("Look how good we are...");
        cash -= moralFibre.actSociallyResponsibly();
        cash -= moralFibre.cleanupEnvironment();
        cash -= moralFibre.empowerEmployees();
    }
}