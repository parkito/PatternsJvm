/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package interpreter.exercise1;

import maths.*;

import java.util.stream.*;

/**
 * Facade for Expression elements, to make the framework easier to use.
 */
public class Expressions {
    private Expressions() {}

    public static Expression sum(String... numbers) {
        return new Sum(convertToExpressions(numbers));
    }

    public static Expression product(String... numbers) {
        return new Product(convertToExpressions(numbers));
    }

    private static Expression[] convertToExpressions(String[] numbers) {
        return Stream.of(numbers).map(Value::new).toArray(Expression[]::new);
    }

    public static Expression negate(Expression exp) {
        return new Product(exp, new Value("-1"));
    }
}
