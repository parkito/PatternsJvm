package ru.siksmfp.java.patterns.structural.momento;

import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Company {
    private Map<Employee, Deque<Momento>> history = new ConcurrentHashMap<>();

    public void promote(Employee employee) {
        snapshot(employee);
        employee.promote();
    }

    public void pay(Employee employee) {
        snapshot(employee);
        employee.pay();
    }

    private void snapshot(Employee employee) {
        Momento momento = employee.createMomento();
        history.computeIfAbsent(employee, v -> new ConcurrentLinkedDeque<>())
                .addLast(momento);
    }

    public void undoLastAction(Employee employee) {
        Deque<Momento> momentos = history.get(employee);
        if (momentos != null) {
            momentos.pollLast();
        }
    }
}
