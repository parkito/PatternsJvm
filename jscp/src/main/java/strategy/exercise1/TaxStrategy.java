/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package strategy.exercise1;

public enum TaxStrategy {
    EMPLOYEE {
        public static final double EMPLOYEE_RATE = 0.45;

        public double extortCash(TaxPayer context) {
            return context.getIncome() * EMPLOYEE_RATE;
        }
    },
    COMPANY {
        private static final double COMPANY_RATE = 0.30;

        public double extortCash(TaxPayer context) {
            return context.getIncome() * COMPANY_RATE;
        }
    },
    TRUST {
        public static final double TRUST_RATE = 0.35;

        public double extortCash(TaxPayer context) {
            return context.getIncome() * TRUST_RATE;
        }
    };

    abstract double extortCash(TaxPayer context);
}
