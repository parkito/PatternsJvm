/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package flyweight.solution1;

import java.util.concurrent.*;

public class MemorySavingNumberFactory extends NumberFactory {
    private final ConcurrentMap<String, Byte> bytes =
        new ConcurrentHashMap<>();

    public Byte getNumber(String b) {
        return bytes.computeIfAbsent(b, Byte::new);
    }

    /**
     * Could also be implemented as follows, this uses Autoboxing to
     * automatically share the objects, then we do not need the map.
     */
    public Byte getNumberJava5(String b) {
        return Byte.parseByte(b);
    }
}
