/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package singleton.exercise3;


import java.lang.reflect.*;

/**
 * Please make the Earth and the two methods spin() and warmUp() abstract.
 * <p/>
 * Next use the system property "earthclass" to decide what earth class to make.
 * Use the FastEarth as your default.
 */
public abstract class Earth {
    private volatile static Earth earth;

    public static Earth getEarth() {
        if (earth == null) {
            synchronized (Earth.class) {
                try {
                    String earthClassName = System.getProperty("earthclass",
                        FastEarth.class.getName());
                    Class<? extends Earth> earthClass = Class.forName(earthClassName, true,
                        Thread.currentThread().getContextClassLoader()).asSubclass(Earth.class);
                    Constructor<? extends Earth> earthConstructor = earthClass.getDeclaredConstructor();
                    earthConstructor.setAccessible(true);
                    earth = (Earth) earthConstructor.newInstance();
                } catch (ReflectiveOperationException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
        return earth;
    }

    protected Earth() {
    }

    public abstract void spin();

    public abstract void warmUp();
}
