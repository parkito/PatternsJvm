/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.iterator;

import java.util.*;
import java.util.concurrent.*;

public class IteratorTest {
    public static void main(String... args) {
        Collection<String> names = ConcurrentHashMap.newKeySet();
//        Collection<String> names = new ConcurrentSkipListSet<>();
        names.add("Susie");
        Iterator<String> it = names.iterator();
        names.add("Peter");
        while(it.hasNext()) {
            System.out.println("it.next() = " + it.next());
        }
        Collections.addAll(names,
            "John", "Anton", "Heinz", "Zach");
//        names.removeIf(s -> s.contains("n"));
//        System.out.println("names = " + names);
        Iterator<String> en = names.iterator();
        while(en.hasNext()) {
            String name = en.next();
            if (name.contains("e")) names.remove(name);
        }
        System.out.println("names = " + names);
        // ConcurrentModificationException
        // Zach
        // something else?
    }
}
