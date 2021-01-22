/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package playground.playground.factorymethod;

import javax.swing.*;
import javax.swing.table.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TableModelMess {
    public static void main(String... args) {
        SwingUtilities.invokeLater(TableModelMess::init);
    }

    private static void init() {
        JFrame frame = new JFrame("What a meSSS - 3x4 table");
        new MyCustomTable(3, 4);
        MyCustomTable table = new MyCustomTable(3, 4);
        frame.add(new JScrollPane(table));
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(-900, 500);
    }

    private static class MyCustomTable extends JTable {
        private final int rows, cols;
        private static final ThreadLocal<int[]> rowcol
            = new ThreadLocal<>();

        public MyCustomTable(int rows, int cols) {
            super(saveRowCol(rows, cols));
            this.rows = rows;
            this.cols = cols;
            rowcol.remove();
        }

        private static TableModel saveRowCol(int rows, int cols) {
            rowcol.set(new int[] {rows, cols});
            return null;
        }

        protected TableModel createDefaultDataModel() {
            int[] rc = rowcol.get();
            if (rc != null) {
                return new DefaultTableModel(rc[0], rc[1]);
            } else {
                return new DefaultTableModel(rows, cols);
            }
        }
    }
}
