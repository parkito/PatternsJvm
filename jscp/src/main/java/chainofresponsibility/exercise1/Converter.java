/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package chainofresponsibility.exercise1;

public abstract class Converter {
    private final Converter next;

    public Converter(Converter next) {
        this.next = next;
    }

    public Object handle(Object o) {
        return next == null ? o : next.handle(o);
    }
}
