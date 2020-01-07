package ru.siksmfp.java.patterns.structural.proxy.classic;

public class Client {

    private Service service;

    public Client(Service service) {
        this.service = service;
    }

    public void doJob() {
        System.out.println(service.getBigPrimeNumber());
    }
}
