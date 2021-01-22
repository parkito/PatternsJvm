/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package interpreter.solution1;

import java.util.stream.*;

/**
 * Facade for Expression elements, to make the framework easier to use.
 */
public class Expressions {
    private Expressions() {
    }

    public static Expression sum(String... numbers) {
        return Stream.of(numbers)
            .map(number -> (Expression) new Value(number))
            .reduce(new Value("0"), (value1, value2) -> new Sum(value1, value2));
    }

    public static Expression product(String... numbers) {
        return Stream.of(numbers)
            .map(number -> (Expression) new Value(number))
            .reduce(new Value("1"), (value1, value2) -> new Product(value1, value2));
    }

    public static Expression negate(Expression exp) {
        return new Product(new Value("-1"), exp);
    }
}
