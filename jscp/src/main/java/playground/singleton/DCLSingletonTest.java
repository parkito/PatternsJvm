/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.singleton;

public class DCLSingletonTest {
    public static void main(String... args) {
        for (int i = 0; i < 10; i++) {
            try {
                DCLSingleton.getInstance().foo();
            } catch(Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
