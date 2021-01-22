/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.proxy;

import proxy.exercise2.*;

public class ATest {
    public static void main(String... args) {
        C c1 = new C(new C(new C(new B(42))));
        C c2 = new C(c1);
        A dyn = Proxies.makeSimpleProxy(
            A.class, c1
        );
        B b1 = new B(42);
        B b2 = new B(42);
        System.out.println(b1.equals(b2));
        System.out.println(b2.equals(b1));
        System.out.println(c1.equals(b1));
        System.out.println(b1.equals(c1));
        System.out.println(c1.equals(c2));
        System.out.println(c2.equals(c1));

        System.out.println(dyn.equals(b1));
        System.out.println(dyn.equals(b2));
        System.out.println(dyn.equals(c1));
        System.out.println(dyn.equals(c2));
        System.out.println(b1.equals(dyn));
        System.out.println(b2.equals(dyn));
        System.out.println(c1.equals(dyn));
        System.out.println(c2.equals(dyn));
    }
}
