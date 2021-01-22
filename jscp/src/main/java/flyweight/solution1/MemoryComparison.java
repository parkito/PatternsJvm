/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package flyweight.solution1;

public class MemoryComparison {
    public long calculateMemoryUsage() {
        Object handle = makeFactory();
        long mem0 = Runtime.getRuntime().totalMemory() -
            Runtime.getRuntime().freeMemory();
        long mem1 = Runtime.getRuntime().totalMemory() -
            Runtime.getRuntime().freeMemory();
        handle = null;
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        mem0 = Runtime.getRuntime().totalMemory() -
            Runtime.getRuntime().freeMemory();
        handle = makeFactory();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        mem1 = Runtime.getRuntime().totalMemory() -
            Runtime.getRuntime().freeMemory();
        return mem1 - mem0;
    }

    public void showMemoryUsage() {
        long mem = calculateMemoryUsage();
        System.out.println(
            " which took " + mem + " bytes");
    }

    public static void main(String... args) {

        MemoryComparison mc = new MemoryComparison();
        mc.showMemoryUsage();
        Object fac = makeFactory();
        fac = null;
        forceGC();
        long mem0 = getUsedMemory();
        fac = makeFactory();
        forceGC();
        long mem1 = getUsedMemory();
        System.out.println("mem1-mem0 = " + (mem1 - mem0));

    }

    private static long getUsedMemory() {
        return Runtime.getRuntime().totalMemory() -
            Runtime.getRuntime().freeMemory();
    }

    private static void forceGC() {
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
    }

    private static Object makeFactory() {
        return Long.valueOf("30");
    }

    private static Object makeFactory4() {
        NumberFactory result = new HighPerformanceNumberFactory();
        for (int i = -128; i < 128; i++) {
            result.getNumber(Integer.toString(i));
        }
        return result;
    }

    private static Object makeFactory2() {
        NumberFactory result = new MemorySavingReleasingNumberFactory();
        for (int i = -128; i < 128; i++) {
            result.getNumber(Integer.toString(i));
        }
        return result;
    }

    private static NumberFactory makeFactory1() {
        NumberFactory result = new MemorySavingNumberFactory();
        for (int i = -128; i < 128; i++) {
            result.getNumber(Integer.toString(i));
        }
        return result;
    }
}
