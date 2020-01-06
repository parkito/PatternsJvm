package ru.siksmfp.java.patterns.structural.momento;

public class MomentoImpl implements Momento {
    private final String uuid;
    private final Position position;
    private final int salary;
    private final int balance;

    public MomentoImpl(Employee employee) {
        uuid = employee.getUuid();
        position = employee.getPosition();
        salary = employee.getSalary();
        balance = employee.getBalance();
    }

    public String getUuid() {
        return uuid;
    }

    public Position getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public int getBalance() {
        return balance;
    }
}
