/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package bridge.exercise1;

import java.awt.*;

//ConcreteImplementor
public class DrawingImpl2 implements Drawing {
    private final DrawingTool2 tool = new DrawingTool2();

    public void drawLine(int x1, int y1, int x2, int y2) {
        tool.drawLine(new Point(x1, y1), new Point(x2, y2));
    }

    public void drawCircle(int x, int y, int r) {
        tool.drawCircle(new Point(x, y), r);
    }
}
