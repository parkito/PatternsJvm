/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.singleton;

public class DCLSingleton {
  // volatile extremely important!
  private static volatile DCLSingleton instance;
  private DCLSingleton() {
      notifyAll();
  }
  public static DCLSingleton getInstance() {
    if (instance == null) {
      synchronized(DCLSingleton.class) {
        if (instance == null) {
          instance = new DCLSingleton();
        }
      }
    }
    return instance;
  }
  public void foo() {}
}
