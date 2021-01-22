/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package singleton.exercise3;

public class FastEarth extends Earth {
    private FastEarth() {
    }

    public void spin() {
        System.out.println("FastEarth.spin");
    }

    public void warmUp() {
        System.out.println("FastEarth.warmUp");
    }
}
