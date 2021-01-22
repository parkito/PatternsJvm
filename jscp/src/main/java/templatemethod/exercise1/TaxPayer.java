/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package templatemethod.exercise1;

public abstract class TaxPayer {
    private final double income;

    public TaxPayer(double income) {
        this.income = income;
    }

    /**
     * This will become our template method.
     */
    public final double calculateTax() {
        return isTaxExempt() || getIncome() < 0 ?
            0.0 : getIncome() * getTaxRate();
    }

    protected abstract boolean isTaxExempt();

    protected abstract double getTaxRate();

    protected final double getIncome() {
        return income;
    }
}
