/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package singleton.exercise1;


/**
 * In the first exercise, please change the Earth to contain a static final
 * field that points to Earth and make the spin() and warmUp() methods
 * non-static.
 */
public class Earth {
    private final static Earth earth = new Earth();

    private Earth() {
    }

    public static Earth getEarth() {
        return earth;
    }

    public void spin() {
        System.out.println("Earth is spinning");
    }

    public void warmUp() {
        System.out.println("Earth is warming up");
    }
}
