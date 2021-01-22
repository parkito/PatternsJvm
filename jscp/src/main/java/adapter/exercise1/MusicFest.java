/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package adapter.exercise1;

import java.util.*;

public class MusicFest {
    private final List<Performer> performers = new ArrayList<>();

    public void addPerformer(Performer performer) {
        performers.add(performer);
    }

    public void singAll() {
        performers.forEach(Performer::perform);
    }
}
