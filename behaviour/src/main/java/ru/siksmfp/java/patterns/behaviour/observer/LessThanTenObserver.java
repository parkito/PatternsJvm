package ru.siksmfp.java.patterns.behaviour.observer;

import java.util.Objects;

public class LessThanTenObserver implements Observer {
    private String id;
    private Subject subject;

    public LessThanTenObserver(String id, Subject subject) {
        this.id = id;
        this.subject = subject;
        subject.subscribe(this);
    }

    @Override
    public <T> void update(T data) {
        if (data instanceof Integer && (int) data < 10) {
            System.out.println(id + " " + data);
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessThanTenObserver that = (LessThanTenObserver) o;
        return Objects.equals(id, that.id) && Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject);
    }
}
