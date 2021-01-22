/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.observer;

import java.util.*;

public class MemoryWarningSystemTest {
    private void memoryUsageLow(long usedMemory, long maxMemory) {
        System.out.println("Used " + usedMemory + " out of " +
            maxMemory + " by " + Thread.currentThread());
    }

    public static void main(String... args) throws InterruptedException {
        MemoryWarningSystem mws = new MemoryWarningSystem();
        mws.addListener(new MemoryWarningSystemTest()::memoryUsageLow);
        mws.setPercentageUsageThreshold(0.5);
        List<byte[]> leak = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.println("i = " + i);
            leak.add(new byte[(int) (Runtime.getRuntime().maxMemory() / 100)]);
            Thread.sleep(100);
        }
    }
}
