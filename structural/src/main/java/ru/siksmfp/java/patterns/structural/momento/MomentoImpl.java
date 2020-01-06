package ru.siksmfp.java.patterns.structural.momento;

public class MomentoImpl implements Momento {
    private final Position position;
    private final int salary;
    private final int balance;

    public MomentoImpl(Employee employee) {
        position = employee.getPosition();
        salary = employee.getSalary();
        balance = employee.getBalance();
    }
}
