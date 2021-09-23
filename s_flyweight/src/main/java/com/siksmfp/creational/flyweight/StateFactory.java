package com.siksmfp.creational.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StateFactory { // Singleton
    private static final StateFactory INSTANCE = new StateFactory();
    private final Map<Class<? extends State>, State> flyweights = new ConcurrentHashMap<>();

    public static StateFactory getInstance() {
        return INSTANCE;
    }

    public State get(Class<? extends State> type) {
        return flyweights.computeIfAbsent(type, this::create);
    }

    private State create(Class<? extends State> type) {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException();
        }
    }
}