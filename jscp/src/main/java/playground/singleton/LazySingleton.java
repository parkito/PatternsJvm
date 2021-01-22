/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.singleton;

public class LazySingleton {
  private final static LazySingleton instance =
    new LazySingleton();

  public static LazySingleton getInstance() {
    return instance;
  }

  private LazySingleton() {
      notifyAll();
  }

  public void foo() { }

  public void bar() { }
}
