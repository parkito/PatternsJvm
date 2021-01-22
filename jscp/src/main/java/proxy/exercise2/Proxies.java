/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package proxy.exercise2;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;

public class Proxies {
    public static <T> T virtual(
        ClassLoader loader, Class<T> subject,
        Supplier<? extends T> supplier) {
        return subject.cast(Proxy.newProxyInstance(
            loader, new Class<?>[]{subject}, new VirtualProxy<T>(supplier)));
    }

    public static <T> T virtual(Class<T> subject, Supplier<? extends T> supplier) {
        return virtual(Thread.currentThread().getContextClassLoader(),
            subject, supplier);
    }

    public static <T> T makeSimpleProxy(Class<T> subject, T realSubject) {
        return makeSimpleProxy(Thread.currentThread().getContextClassLoader(),
            subject, realSubject);
    }

    public static <T> T makeSimpleProxy(ClassLoader loader, Class<T> subject, T realSubject) {
        return subject.cast(Proxy.newProxyInstance(
            loader,
            new Class<?>[]{subject},
            (proxy, method, args) -> method.invoke(realSubject, args)
        ));
    }

    private static class VirtualProxy<T> implements InvocationHandler {
        private final Supplier<? extends T> supplier;
        private volatile T realSubject;

        public VirtualProxy(Supplier<? extends T> supplier) {
            this.supplier = supplier;
        }

        private T realSubject() {
            if (realSubject == null) {
                synchronized (this) {
                    if (realSubject == null)
                        realSubject = supplier.get();
                }
            }
            return realSubject;
        }

        // called whenever any method is called on interface
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxy = " + proxy.getClass());
            System.out.println(Arrays.toString(proxy.getClass().getInterfaces()));
            return method.invoke(realSubject(), args);
        }
    }
}
