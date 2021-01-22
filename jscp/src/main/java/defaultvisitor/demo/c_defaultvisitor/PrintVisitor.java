/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package defaultvisitor.demo.c_defaultvisitor;

public class PrintVisitor implements DefaultVisitor {
    protected final StringBuilder sb = new StringBuilder();

    public void visitPlus(Plus s) {
        sb.append("+ ");
    }

    public void visitNumber(Number n) {
        sb.append(n.getValue()).append(' ');
    }

    public void visitExpression(Expression e) {
        sb.append("? ");
    }

    public String toString() {
        return sb.toString().trim();
    }
}
