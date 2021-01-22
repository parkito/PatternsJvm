/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.observer;

import javax.management.*;
import javax.management.openmbean.*;
import java.lang.management.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * This memory warning system will call the listener when we
 * exceed the percentage of available memory specified.  There
 * should only be one instance of this object created, since the
 * usage threshold can only be set to one number.
 */
public class MemoryWarningSystem {
    private final Collection<Listener> listeners =
        new CopyOnWriteArraySet<>();

    public interface Listener {
        public void memoryUsageLow(long usedMemory, long maxMemory);
    }

    private Object hbtemp;

    public MemoryWarningSystem() {
        MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
        NotificationEmitter emitter = (NotificationEmitter) mbean;
        emitter.addNotificationListener((Notification n, Object hb) -> {
            if (n.getType().equals(MemoryNotificationInfo.MEMORY_THRESHOLD_EXCEEDED)) {
                CompositeData userData = (CompositeData) n.getUserData();
                CompositeData usage = (CompositeData) userData.get("usage");
                hbtemp = usage;
                long usedMemory = (long) usage.get("used");
                long maxMemory = (long) usage.get("max");
                for (Listener listener : listeners) {
                    listener.memoryUsageLow(usedMemory, maxMemory);
                }
            }
        }, null, null);
    }

    public boolean addListener(Listener listener) {
        return listeners.add(listener);
    }

    public boolean removeListener(Listener listener) {
        return listeners.remove(listener);
    }

    private static final MemoryPoolMXBean tenuredGenPool =
        findTenuredGenPool();

    public static void setPercentageUsageThreshold(double percentage) {
        if (percentage <= 0.0 || percentage > 1.0) {
            throw new IllegalArgumentException("Percentage not in range");
        }
        long maxMemory = tenuredGenPool.getUsage().getMax();
        long warningThreshold = (long) (maxMemory * percentage);
        tenuredGenPool.setUsageThreshold(warningThreshold);
    }

    /**
     * Tenured Space Pool can be determined by it being of type
     * HEAP and by it being possible to set the usage threshold.
     */
    private static MemoryPoolMXBean findTenuredGenPool() {
        for (MemoryPoolMXBean pool :
            ManagementFactory.getMemoryPoolMXBeans()) {
            // I don't know whether this approach is better, or whether
            // we should rather check for the pool name "Tenured Gen"?
            if (pool.getType() == MemoryType.HEAP &&
                pool.isUsageThresholdSupported()) {
                return pool;
            }
        }
        throw new AssertionError("Could not find tenured space");
    }

}
