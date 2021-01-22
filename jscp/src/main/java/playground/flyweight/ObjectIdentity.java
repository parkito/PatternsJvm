/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.flyweight;

import org.junit.*;

import java.util.function.*;

import static org.junit.Assert.*;

public class ObjectIdentity {
    @Test
    public void testSameness() {
        String greeting = new String(
            new char[]{
                'h', 'e', 'l', 'l', 'o'
            }
        );


        System.out.printf("System.identityHashCode(greeting) = %x%n",
            System.identityHashCode(greeting));
        greeting = greeting.intern();
        compare("hello", greeting);
        System.out.println("greeting = " + greeting);
        compare("hello", "hello");
        compare("goodbye", "goodbye");

        compare(new Holder1().name,
            new Holder2().name);

        // -128 -> 127
        compare(123, 123);
//        compare(321, 321);
//        compare(4321, 4321);
//        compare(54321, 54321);

        compare(sayHelloAction(), sayHelloAction());
    }

    private void compare(Object o1, Object o2) {
        System.out.printf("%x, %x%n",
            System.identityHashCode(o1),
            System.identityHashCode(o2));
        assertSame(o1, o2);
    }

    private String name;
    public Consumer<String> sayHelloAction() {
        return s -> System.out.println("Hello world " + s);
    }
}
