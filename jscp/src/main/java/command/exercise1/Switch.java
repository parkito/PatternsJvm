/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package command.exercise1;

// Invoker
public final class Switch {
    private final Command up, down;

    public Switch(Command up, Command down) {
        this.up = up;
        this.down = down;
    }

    public void flipUp() {
        up.execute();
    }

    public void flipDown() {
        down.execute();
    }
}
