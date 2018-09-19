package main.java.ru.siksmfp.java.patterns.command;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            exec.execute(new Run());
        }
        exec.shutdown();
    }
}
