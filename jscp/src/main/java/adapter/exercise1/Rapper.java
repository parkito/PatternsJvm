/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package adapter.exercise1;

public class Rapper {
    public Rapper() {
        System.out.println("Rapper <init>");
    }

    public void talk() {
        System.out.println("Vulgar lyrics deleted ...");
    }
}