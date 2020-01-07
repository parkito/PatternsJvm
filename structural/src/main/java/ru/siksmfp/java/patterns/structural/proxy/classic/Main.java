package ru.siksmfp.java.patterns.structural.proxy.classic;

public class Main {

    public static void main(String[] args) {
        Client client = new Client(new ProxyService());

        client.doJob();
    }
}
