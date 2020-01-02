/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package ru.siksmfp.java.patterns.creational.builder;

//Example of builder pattern from effective java book
public class CustomThread {

    private Runnable target;
    private String name;
    private ThreadGroup threadGroup;
    private long stackSize;
    private boolean inheritThreadLocals;
    private Boolean daemon;
    private Integer priority;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    private CustomThread(ThreadGroup threadGroup, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
        this.threadGroup = threadGroup;
        this.target = target;
        this.name = name;
        this.stackSize = stackSize;
        this.inheritThreadLocals = inheritThreadLocals;
    }

    public static class ThreadBuilder {
        private Runnable target;
        private String name;
        private ThreadGroup threadGroup;
        private long stackSize;
        private boolean inheritThreadLocals;
        private Boolean daemon;
        private Integer priority;
        private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

        public ThreadBuilder(Runnable target, String name) {
            this.target = target;
            this.name = name;
        }

        public ThreadBuilder threadGroup(ThreadGroup threadGroup) {
            this.threadGroup = threadGroup;
            return this;
        }

        public ThreadBuilder stackSize(long stackSize) {
            this.stackSize = stackSize;
            return this;
        }

        public ThreadBuilder inheritThreadLocals(boolean inheritThreadLocals) {
            this.inheritThreadLocals = inheritThreadLocals;
            return this;
        }

        public ThreadBuilder daemon(boolean daemon) {
            this.daemon = daemon;
            return this;
        }

        public ThreadBuilder priority(int priority) {
            this.priority = priority;
            return this;
        }

        public ThreadBuilder uncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.uncaughtExceptionHandler = uncaughtExceptionHandler;
            return this;
        }

        public CustomThread build() {
            CustomThread thread = new CustomThread(threadGroup, target, name, stackSize, inheritThreadLocals);

            if (daemon != null) {
                thread.daemon = daemon;
            }
            if (priority != null) {
                thread.priority = priority;
            }
            if (uncaughtExceptionHandler != null) {
                thread.uncaughtExceptionHandler = uncaughtExceptionHandler;
            }
            return thread;
        }
    }
}
