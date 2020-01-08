package ru.siksmfp.java.patterns.structural.proxy.dynamic;

public class VirtualMoralFibre implements MoralFibre {
    private MoralFibre realSubject;

    private MoralFibre realSubject() {
        if (realSubject == null) {
            realSubject = new RealMoralFibre();
        }
        return realSubject;
    }

    public double actSociallyResponsibly() {
        return realSubject().actSociallyResponsibly();
    }

    public double empowerEmployees() {
        return realSubject().empowerEmployees();
    }

    public double cleanupEnvironment() {
        return realSubject().cleanupEnvironment();
    }
}
