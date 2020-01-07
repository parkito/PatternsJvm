package ru.siksmfp.java.patterns.structural.proxy.classic;

public class ProxyService implements Service {
    private Service service;

    @Override
    public long getBigPrimeNumber() {
        return getService().getBigPrimeNumber();
    }

    private Service getService() {
        synchronized (this) {
            if (service == null) {
                service = new ServiceImpl();
            }
        }
        return service;
    }
}
