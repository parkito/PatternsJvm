/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package adapter.exercise1;

import org.junit.*;
import util.*;

import java.lang.reflect.*;

import static org.junit.Assert.*;

public class AdapterTest {
    @Test
    public void testClassAdapterStructure() {
        try {
            Class<?> adap = ClassHelper.getClass("RapperClassAdapter");
            assertEquals("Class adapter should not have fields", 0, adap.getDeclaredFields().length);
            assertEquals("Class adapter should have one method, perform()", "perform", adap.getDeclaredMethods()[0].getName());
            assertFalse("Class adapter should not be abstract", Modifier.isAbstract(adap.getModifiers()));
            assertTrue("Class adapter should also be a Performer", Performer.class.isAssignableFrom(adap));
            assertTrue("Class adapter should also be a Rapper", Rapper.class.isAssignableFrom(adap));
        } catch (ClassNotFoundException e) {
            fail("Need a class adapter called RapperClassAdapter");
        }
    }

    @Test
    public void testObjectAdapterStructure() {
        try {
            Class<?> adap = ClassHelper.getClass("RapperObjectAdapter");
            assertEquals("Object adapter needs a field pointing to a Rapper", Rapper.class, adap.getDeclaredFields()[0].getType());
            assertEquals("Object adapter should have one method, perform()", "perform", adap.getDeclaredMethods()[0].getName());
            assertFalse("Object adapter should not be abstract", Modifier.isAbstract(adap.getModifiers()));
            assertTrue("Object adapter should also be a Performer", Performer.class.isAssignableFrom(adap));
            assertFalse("Object adapter should not be a Rapper", Rapper.class.isAssignableFrom(adap));
            try {
                adap.getDeclaredConstructor(Rapper.class);
            } catch (NoSuchMethodException e) {
                fail("Object adapter should have a constructor taking a Rapper");
            }
            assertEquals("Object adapter should have one constructor", 1, adap.getDeclaredConstructors().length);
        } catch (ClassNotFoundException e) {
            fail("Need a Object adapter called RapperObjectAdapter");
        }
    }

    @Test
    public void testAdapterInstantiations() throws Exception {
        Class<? extends Performer> objadapcl = ClassHelper.getClass("RapperObjectAdapter").asSubclass(Performer.class);
        Constructor<? extends Performer> objconstr = objadapcl.getDeclaredConstructor(Rapper.class);
        Performer objadap = objconstr.newInstance(new Rapper());
        Class<? extends Performer> clsadapcl = ClassHelper.getClass("RapperClassAdapter").asSubclass(Performer.class);
        Performer clsadap = clsadapcl.getConstructor().newInstance();

        MusicFest fest = new MusicFest();
        fest.addPerformer(new Bass());
        fest.addPerformer(new Soprano());
        fest.addPerformer(objadap);
        fest.addPerformer(clsadap);
        fest.singAll();
    }
}
