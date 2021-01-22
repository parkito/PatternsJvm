/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package proxy.exercise1;

public class VirtualLutefisk implements Lutefisk {
    private Lutefisk realSubject;

    public void eat() {
        if (realSubject == null) {
            realSubject = new RealLutefisk();
        }
        realSubject.eat();
    }
}
