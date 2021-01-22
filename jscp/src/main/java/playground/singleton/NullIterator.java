/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.singleton;

import java.util.*;

public class NullIterator<E> implements Iterator<E> {
    private final static NullIterator instance =
        new NullIterator();
    private NullIterator() {}

    public static <T> Iterator<T> getInstance() {
        return instance;
    }

    public boolean hasNext() {
        return false;
    }

    public E next() {
        throw new NoSuchElementException("null iterator");
    }

    public void remove() {
        throw new IllegalStateException();
    }
}
