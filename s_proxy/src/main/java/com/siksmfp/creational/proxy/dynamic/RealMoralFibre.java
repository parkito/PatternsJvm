package com.siksmfp.creational.proxy.dynamic;

public class RealMoralFibre implements MoralFibre { // very expensive to make moral fibre!
    private final byte[] costOfMoralFibre = new byte[900_000];

    static {
        System.out.println("Moral Fibre Created!");
    }

    public double actSociallyResponsibly() { // AIDS orphans
        return costOfMoralFibre.length / 3;
    }

    public double empowerEmployees() { // shares to employees
        return costOfMoralFibre.length / 3;
    }

    public double cleanupEnvironment() { // oiled sea birds
        return costOfMoralFibre.length / 3;
    }
}
