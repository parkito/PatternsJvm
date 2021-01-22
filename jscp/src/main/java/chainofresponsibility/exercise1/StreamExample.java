/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package chainofresponsibility.exercise1;

import java.util.stream.*;

public class StreamExample {
    public static void main(String... args) {
        // the following code should run and produce the output:
        // HEINZ
        // 5.0
        // 4.0
        // INTERESTING
        // SÜSS
        //*
//        */
        Stream.of("    heinz   ", 4.5d, 4.49999999999d, "interesting", "süß")
            .map(StreamExample::trimString)
            .map(StreamExample::trimDouble)
            .map(StreamExample::upperCaseString)
            .forEach(System.out::println);
    }

    private static Object trimString(Object o) {
        return o instanceof String ? ((String) o).trim() : o;
    }

    private static Object upperCaseString(Object o) {
        return o instanceof String ? ((String) o).toUpperCase() : o;
    }

    private static Object trimDouble(Object o) {
        return o instanceof Double ? (double) (Math.round((Double) o)) : o;
    }
}
