/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package defaultvisitor.demo.c_defaultvisitor;


import java.util.concurrent.atomic.*;

public class NumberCountVisitor implements DefaultVisitor {
    private final LongAdder count = new LongAdder();

    public void visitNumber(Number n) {
        count.increment();
    }

    public long getCount() {
        return count.longValue();
    }
}
