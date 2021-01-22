/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package strategy.exercise1;

public class TaxPayer {
    public static final TaxStrategy COMPANY = TaxStrategy.COMPANY;
    public static final TaxStrategy EMPLOYEE = TaxStrategy.EMPLOYEE;
    public static final TaxStrategy TRUST = TaxStrategy.TRUST;

    private final double income;
    private final TaxStrategy strategy;

    public TaxPayer(TaxStrategy strategy, double income) {
        this.strategy = strategy;
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public double extortCash() {
        return strategy.extortCash(this);
    }
}
