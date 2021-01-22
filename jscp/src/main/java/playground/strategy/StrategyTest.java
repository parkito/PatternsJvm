/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.strategy;

import java.lang.invoke.*;
import java.util.zip.*;

public class StrategyTest {
    public static void main(String... args) {
        System.out.println(
            new StringBuilder()
                .append("Hello ")
                .append(args[0]).toString());
        System.out.println("Hello " + args[0]);
    }
}
