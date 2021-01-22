/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package visitor.exercise1;

import maths.*;

/**
 * This must count how many leaves there are in structure, how many distribution
 * lists and what the average number of contacts in a distribution list.
 * <p/>
 * Use the maths.Statistics class to work out the mean and variance for the list
 * lengths.
 */
public class CountingVisitor implements Visitor {
    private final Statistics composites = new Statistics();
    private int leaves = 0;

    public int getNumberOfLeaves() {
        return leaves;
    }

    public int getNumberOfComposites() {
        return composites.size();
    }

    public double getAverageNumberOfChildrenPerComposite() {
        return composites.getMean();
    }

    public double getVarianceNumberOfChildrenPerComposite() {
        return composites.getVariance();
    }

    public void visit(Person p) {
        leaves++;
    }

    public void visit(DistributionList dl) {
        composites.add(dl.getNumberOfChildren());
    }
}
