package ru.siksmfp.java.patterns.structural.momento;

import java.util.Objects;

import static ru.siksmfp.java.patterns.structural.momento.Position.CODER;
import static ru.siksmfp.java.patterns.structural.momento.Position.TESTER;

public class Employee {
    private final String uuid;
    private Position position = TESTER;
    private int balance;
    private int salary = 100;

    public Employee(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public Position getPosition() {
        return position;
    }

    public int getBalance() {
        return balance;
    }

    public int getSalary() {
        return salary;
    }

    public void pay() {
        balance += salary;
    }

    public void promote() {
        switch (position) {
            case TESTER:
                position = CODER;
                salary += 100;
                break;
            case CODER:
                position = TESTER;
                salary += 200;
                break;
        }
    }

    public Momento createMomento() {
        return new MomentoImpl(this);
    }

    public void setMomento(Momento momento) {
        MomentoImpl momentoImpl = (MomentoImpl) momento;
        if (!momentoImpl.getUuid().equals(this.uuid)) {
            throw new IllegalStateException("Momento of other employee can't be applied to the current");
        }
        position = momentoImpl.getPosition();
        balance = momentoImpl.getBalance();
        salary = momentoImpl.getSalary();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return balance == employee.balance &&
                salary == employee.salary &&
                Objects.equals(uuid, employee.uuid) &&
                position == employee.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, position, balance, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "uuid='" + uuid + '\'' +
                ", position=" + position +
                ", balance=" + balance +
                ", salary=" + salary +
                '}';
    }
}
