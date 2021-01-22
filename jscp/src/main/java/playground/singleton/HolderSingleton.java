/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.singleton;

public class HolderSingleton {
    public void foo() {
    }

    private static class SingletonHolder {
        static final HolderSingleton instance = makeSingleton();
    }

    private HolderSingleton() {
        notifyAll();
    }

    private static HolderSingleton makeSingleton() {
        return new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
