package ru.siksmfp.java.patterns.structural.momento;

import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Company {
    private Map<String, Deque<Momento>> history = new ConcurrentHashMap<>();

    public void promote(Employee employee) {
        snapshot(employee);
        employee.promote();
    }

    public void pay(Employee employee) {
        snapshot(employee);
        employee.pay();
    }

    public void undoLastAction(Employee employee) {
        Deque<Momento> momentos = history.get(employee.getUuid());
        if (momentos != null) {
            Momento last = momentos.pollLast();
            if (last != null) {
                employee.setMomento(last);
                return;
            }
        }
        throw new IllegalStateException("Can't perform undo action due to history sate");
    }

    private void snapshot(Employee employee) {
        Momento momento = employee.createMomento();
        history.computeIfAbsent(employee.getUuid(), v -> new ConcurrentLinkedDeque<>())
                .addLast(momento);
    }
}
