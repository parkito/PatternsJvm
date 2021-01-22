/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package defaultvisitor.exercise1;

public interface DefaultVisitor extends Visitor {
    default void visitContact(Contact c) {
        // do nothing
    }

    default void visitAbstractLeafContact(AbstractLeafContact c) {
        visitContact(c);
    }

    default void visitPerson(Person p) {
        visitAbstractLeafContact(p);
    }

    default void visitAbstractCompositeContact(AbstractCompositeContact c) {
        visitContact(c);
    }

    default void visitDistributionList(DistributionList dl) {
        visitAbstractCompositeContact(dl);
    }
}
