/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package interpreter.exercise1;

/**
 * Expression language for fraction maths:
 * <p>
 * expression ::= sum
 * sum ::= product ((' + ' | ' - ') product)*
 * product ::= value ((' * ' | ' / ') value)*
 * value ::= -?\d+(/-?\d+)? | '(' expression ')'
 * <p>
 * 1/3 + 2/3 / 1/2 * 3/4 + 1/2 - 5/6
 */
public interface Expression {
    String interpret();
}