package com.siksmfp.creational.proxy.classic;

public class Client {

    private final Service service;

    public Client(Service service) {
        this.service = service;
    }

    public void doJob() {
        System.out.println(service.getBigPrimeNumber());
    }
}
