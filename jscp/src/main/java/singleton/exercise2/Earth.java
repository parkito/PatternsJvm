/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package singleton.exercise2;

/**
 * Please add a getSpeed() method to return the speed as an int.
 */
public class Earth {
    private static final Earth earth = new Earth();

    private final int speed;
    public static Earth getEarth() {
        return earth;
    }

    private Earth() {
        speed = Integer.getInteger("earthspeed", 2000);
    }

    public int getSpeed() {
        return speed;
    }

    public void spin() {
        System.out.println("Earth is spinning at " + speed);
    }

    public void warmUp() {
        System.out.println("Earth is warming up");
    }
}
