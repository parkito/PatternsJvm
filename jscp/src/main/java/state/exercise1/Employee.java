/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package state.exercise1;

/**
 * Code without clear state machine transitions.  It is very
 * ugly.  Your job is to use the state pattern to clean things
 * up.
 */
public class Employee {
    private State state = State.PROGRAMMER;

    public int pay() {
        return state.pay();
    }

    public void advance() {
        setState(state.advance());
    }

    public void fire() {
        setState(state.fire());
    }

    private void setState(State newState) {
        if (newState != state)
            System.out.println(state + " -> " + newState);
        this.state = newState;
    }
}
