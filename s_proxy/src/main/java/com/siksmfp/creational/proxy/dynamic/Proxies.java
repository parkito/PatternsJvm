package com.siksmfp.creational.proxy.dynamic;

import java.lang.reflect.Proxy;
import java.util.function.Supplier;

public class Proxies {
    public static <T> T virtual(ClassLoader loader,
                                Class<T> interfaces,
                                Supplier<T> supplier) {
        return interfaces.cast(Proxy.newProxyInstance(
                loader, new Class<?>[]{interfaces}, new VirtualProxy<>(supplier)));
    }

    public static <T> T virtual(Class<T> interfaces, Supplier<T> supplier) {
        return virtual(Thread.currentThread().getContextClassLoader(),
                interfaces, supplier);
    }
}