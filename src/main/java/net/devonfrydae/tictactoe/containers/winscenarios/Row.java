package net.devonfrydae.tictactoe.containers.winscenarios;

import net.devonfrydae.tictactoe.containers.Table;
import net.devonfrydae.tictactoe.utils.Util;

public class Row {
    private Table table;
    private int row;

    public Row(Table table, int row) {
        this.table = table;
        this.row = row;
    }

    /**
     * Checks if this is a winning row
     *
     * @return true if this is a winning row
     */
    public boolean isWon() {
        if (table.isCellOpen(row, 0)) {
            return false;
        }

        return Util.equals(
                table.getCellDisplay(row, 0),
                table.getCellDisplay(row, 1),
                table.getCellDisplay(row, 2));
    }
}
