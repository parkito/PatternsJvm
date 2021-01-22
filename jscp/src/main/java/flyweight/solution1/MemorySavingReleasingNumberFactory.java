/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package flyweight.solution1;

import java.lang.ref.*;
import java.util.*;
import java.util.concurrent.*;

public class MemorySavingReleasingNumberFactory extends NumberFactory {
    private final Map<String, Reference<Byte>> bytes = new ConcurrentHashMap<>();
    private ReferenceQueue<? super Byte> queue = new ReferenceQueue<>();

    public Byte getNumber(String b) {
        Byte result;
        Reference<Byte> ref = bytes.get(b);
        if (ref == null) {
            result = createNewByte(b);
        } else {
            result = ref.get();
            if (result == null) {
                result = createNewByte(b);
            }
        }
        return result;
    }

    private Byte createNewByte(String b) {
        Byte result = Byte.valueOf(b);
        bytes.put(b, new WeakReference<>(result, queue));
        return result;
    }

    {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    queue.remove();
                    bytes.entrySet().removeIf(entry -> entry.getValue().get() == null);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    /**
     * Could also be implemented as follows, this uses Autoboxing to
     * automatically share the objects, then we do not need the map.
     */
    public Byte getNumberJava5(String b) {
        return Byte.parseByte(b);
    }
}
