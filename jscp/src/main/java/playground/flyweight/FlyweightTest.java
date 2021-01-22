/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.flyweight;

import java.sql.*;

public class FlyweightTest {
    public FlyweightTest() throws SQLException {
        throw new SQLException("Could not connect to DB");
    }
    public static void main(String... args)
        throws IllegalAccessException,
        InstantiationException {
        try {
            FlyweightTest.class.newInstance();
        } catch(Exception ex) {
            System.err.println("type is : " + ex.getClass());
        }
    }
}
