/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package memento.exercise1;

import java.lang.ref.*;
import java.util.concurrent.*;

public class LabRat {
    private double cd4Ratio = 0.5;
    private boolean alive = true;

    public void blastWithRadar() {
        if (!alive)
            throw new IllegalStateException("lab rat is dead");
        cd4Ratio /= ThreadLocalRandom.current().nextDouble();
        cd4Ratio -= Math.floor(cd4Ratio);
        checkPulse();
    }

    public void feedDrugs() {
        if (!alive)
            throw new IllegalStateException("lab rat is dead");
        cd4Ratio /= ThreadLocalRandom.current().nextDouble();
        cd4Ratio -= Math.floor(cd4Ratio);
        checkPulse();
    }

    private void checkPulse() {
        if (cd4Ratio < 0.1) {
            alive = false;
        }
        System.out.printf("Lab rat ha%s CD4 ratio of %.2f%n",
            (alive ? "s" : "d"), cd4Ratio);
    }

    public boolean isAlive() {
        return alive;
    }

    public Memento createMemento() {
        return new LabRatMemento(this);
    }

    public void setMemento(Memento memento) {
        LabRatMemento m = (LabRatMemento) memento;
        if (this != m.originator.get())
            throw new IllegalArgumentException("mismatched originator");
        this.cd4Ratio = m.cd4Ratio;
        this.alive = m.alive;
    }

    private static class LabRatMemento implements Memento {
        private final double cd4Ratio;
        private final boolean alive;
        private final Reference<LabRat> originator;

        public LabRatMemento(LabRat originator) {
            this.cd4Ratio = originator.cd4Ratio;
            this.alive = originator.alive;
            this.originator = new WeakReference<>(originator);
        }
    }
}
