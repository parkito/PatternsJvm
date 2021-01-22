/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.proxy;

import org.junit.*;
import proxy.exercise2.*;

import static org.junit.Assert.*;

public class ProxyEqualsTest {
    private static final boolean USE_DYNAMIC_PROXIES = false;

    private A makeProxy(A a) {
        return USE_DYNAMIC_PROXIES ? Proxies.makeSimpleProxy(A.class, a) : new C(a);
    }

    @Test
    public void proxyEqualsProxy() {
        A real = new B(42);
        A proxy1 = makeProxy(real);
        A proxy2 = makeProxy(real);
        assertEquals(proxy1, proxy2);
        assertEquals(proxy2, proxy1);
        assertEquals(proxy1, proxy1);
        assertEquals(proxy2, proxy2);
    }

    @Test
    public void proxyEqualsReal() {
        B b = new B(42);
        A c1 = makeProxy(b);
        assertEquals(c1, b);
    }

    @Test
    public void realEqualsProxy() {
        A real = new B(42);
        A proxy = makeProxy(real);
        assertEquals(real, proxy);
        assertEquals(real, real);
    }
}
