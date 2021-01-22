/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package templatemethod.exercise1;

public class Trust extends TaxPayer {
    private final boolean disability;

    public Trust(boolean disability, double income) {
        super(income);
        this.disability = disability;
    }

    public boolean isDisability() {
        return disability;
    }

    protected double getTaxRate() {
        return 0.40;
    }

    protected boolean isTaxExempt() {
        return disability;
    }
}
