/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.proxy;

import java.util.*;

// proxy
public final class C implements A {
    private final A a;

    public C(A a) {
        Objects.requireNonNull(a);
        this.a = a;
    }

    public int hashCode() {
        return a.hashCode();
    }

    public boolean equals(Object obj) {
        return a.equals(obj);
    }
}
