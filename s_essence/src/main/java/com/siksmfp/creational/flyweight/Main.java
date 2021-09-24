package com.siksmfp.creational.flyweight;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        //not a lot of memory used
        for (long i = 0; i < 1_000_000_000; i++) {
            System.out.print(i + " ");
            if (ThreadLocalRandom.current().nextInt() % 2 == 0) {
                State.create(QuotedState.class).doSomething();
            } else {
                State.create(WorkingState.class).doSomething();
            }
        }

        //GC is very hot
        for (long i = 0; i < 1_000_000_000; i++) {
            System.out.print(i + " ");
            if (ThreadLocalRandom.current().nextInt() % 2 == 0) {
                new QuotedState().doSomething();
            } else {
                new WorkingState().doSomething();
            }
        }
    }
}
