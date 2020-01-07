package ru.siksmfp.java.patterns.structural.proxy.classic;

import java.util.concurrent.ThreadLocalRandom;

public class ServiceImpl implements Service {

    @Override
    public long getBigPrimeNumber() {
        return ThreadLocalRandom.current().nextLong();
    }
}
