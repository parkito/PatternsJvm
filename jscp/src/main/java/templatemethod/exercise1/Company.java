/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package templatemethod.exercise1;

public class Company extends TaxPayer {
    private final boolean nonProfit;

    public Company(boolean nonProfit, double income) {
        super(income);
        this.nonProfit = nonProfit;
    }

    private boolean isNonProfit() {
        return nonProfit;
    }

    protected boolean isTaxExempt() {
        return isNonProfit();
    }

    protected double getTaxRate() {
        return 0.29;
    }
}
