/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package templatemethod.exercise1;

public class Employee extends TaxPayer {
    private final boolean foreignResident;

    public Employee(boolean foreignResident,
                    double income) {
        super(income);
        this.foreignResident = foreignResident;
    }

    private boolean isForeignResident() {
        return foreignResident;
    }

    protected boolean isTaxExempt() {
        return isForeignResident();
    }

    protected double getTaxRate() {
        if (getIncome() < 20000) {
            return 0.0;
        } else if (getIncome() < 50000) {
            return 0.1;
        } else if (getIncome() < 100000) {
            return 0.25;
        } else {
            return 0.45;
        }
    }
}
