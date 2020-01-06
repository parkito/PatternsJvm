package ru.siksmfp.java.patterns.structural.momento;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();
        Employee employee = new Employee("uuid");
        company.pay(employee);
        company.pay(employee);
        company.pay(employee);
        company.pay(employee);
        System.out.println(employee);
        company.promote(employee);
        company.undoLastAction(employee);
        System.out.println(employee);
    }
}
