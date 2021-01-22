/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.nullobject;

public class NullPointerMystery {
    public static String getValue() {
        return null;
    }

    public static void main(String... args) {
        long time = System.currentTimeMillis();
        try {
            Exception previous = null;
            while (true) {
                try {
                    getValue().toUpperCase().toLowerCase();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (e == previous) {
                        System.out.println("We've seen that before!");
                        return;
                    }
                    previous = e;
                }
            }
        } finally {
            time = System.currentTimeMillis() - time;
            System.out.println("time = " + time + "ms");
        }
    }

}
