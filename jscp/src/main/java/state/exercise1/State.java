/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package state.exercise1;

public abstract class State {
    public static final State PROGRAMMER = new ProgrammerState();
    public static final State MANAGER = new ManagerState();
    public static final State RETIREE = new RetireeState();
    public static final State END = new EndState();

    public int pay() {
        return 0;
    }

    public State advance() {
        return this;
    }

    public State fire() {
        return this;
    }

    public final String toString() {
        return getClass().getSimpleName();
    }
}
