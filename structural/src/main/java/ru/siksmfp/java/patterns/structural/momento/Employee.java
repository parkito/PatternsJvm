package ru.siksmfp.java.patterns.structural.momento;

import java.util.Objects;

import static ru.siksmfp.java.patterns.structural.momento.Position.CODER;
import static ru.siksmfp.java.patterns.structural.momento.Position.TESTER;

public class Employee {
    private Position position = TESTER;
    private int balance;
    private int salary = 100;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return balance == employee.balance &&
                salary == employee.salary &&
                position == employee.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, balance, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "position=" + position +
                ", balance=" + balance +
                ", salary=" + salary +
                '}';
    }
}
