/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package flyweight.solution1;

import org.junit.*;

import static org.junit.Assert.*;

public class FlyweightTest {
    @Test
    public void testHighPerformanceNumberFactory() throws Exception {
        NumberFactory makeNewNF = new HighPerformanceNumberFactory();
        Byte b1 = makeNewNF.getNumber("123");
        Byte b2 = makeNewNF.getNumber("123");
        Byte b3 = makeNewNF.getNumber("0123");
        assertNotSame(b1, b2);
        assertNotSame(b2, b3);
        assertNotSame(b1, b3);
    }

    @Test
    public void testMemorySavingNumberFactory() throws Exception {
        NumberFactory makeNewNF = new MemorySavingNumberFactory();
        Byte b1 = makeNewNF.getNumber("123");
        Byte b2 = makeNewNF.getNumber("123");
        Byte b3 = makeNewNF.getNumber("0123");
        assertSame(b1, b2);
        assertEquals(b2, b3);
        assertEquals(b1, b3);
    }
}
