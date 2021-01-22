/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package adapter.exercise1;

public class MusicFestExample {
    public static void main(String... args) {
        MusicFest fest = new MusicFest();
        fest.addPerformer(new Bass());
        fest.addPerformer(new Soprano());
        fest.addPerformer(new Rapper()::talk);
        fest.addPerformer(new Drummer());

        fest.singAll();
        fest.singAll();
        fest.singAll();
    }
}
