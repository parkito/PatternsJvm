/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package defaultvisitor.demo.b_originalvisitorwithminus;

// E2
public final class Minus extends Expression {
    private final Expression first, second;

    public Minus(Expression first, Expression second) {
        this.first = first;
        this.second = second;
    }

    public void accept(Visitor v) {
        first.accept(v);
        second.accept(v);
        v.visitMinus(this);
    }
}
