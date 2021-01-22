/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package abstractfactory.exercise1;

import java.lang.reflect.*;

// AbstractFactory
public abstract class Earth {
    private static volatile Earth earth;
    private final int speed;

    public static Earth getEarth() {
        if (earth == null) {
            synchronized (Earth.class) {
                if (earth == null) {
                    String className = System.getProperty("earthclass",
                        FastEarth.class.getName());
                    try {
                        Class<?> aClass = Class.forName(
                            className, true,
                            Thread.currentThread().getContextClassLoader());
                        Class<? extends Earth> clazz =
                            aClass.asSubclass(Earth.class);
                        Constructor<? extends Earth> earthConstructor = clazz.getDeclaredConstructor();
                        earthConstructor.setAccessible(true);
                        earth = earthConstructor.newInstance();
                    } catch (ReflectiveOperationException e) {
                        throw new IllegalStateException(
                            "Singleton not initialized: " + className, e);
                    }
                }
            }
        }
        return earth;
    }

    protected Earth() {
        speed = Integer.parseInt(System.getProperty("earthspeed", "2000"));
    }

    public abstract void spin();

    public abstract void warmUp();

    public abstract Vehicle createVehicle();

    public abstract Animal createAnimal();
}
