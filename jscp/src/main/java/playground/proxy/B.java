/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.proxy;

// real subject
public final class B implements A {
    private final int i;

    public B(int i) {
        this.i = i;
    }

    public boolean equals(Object o) {
        if (this == o) return true;

        if (o instanceof B) {
            B b = (B) o;
            return i == b.i;
        }
        return o.equals(this);
    }

    public int hashCode() {
        return i;
    }
}
