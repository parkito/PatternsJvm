/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package state.exercise1;

public class ProgrammerState extends WorkerState {
    public int pay() {
        System.out.println("Programmer getting paid");
        return 3000;
    }

    public State advance() {
        return State.MANAGER;
    }
}
