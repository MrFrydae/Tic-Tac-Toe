package net.devonfrydae.tictactoe.containers.winscenarios;

import net.devonfrydae.tictactoe.containers.Table;
import net.devonfrydae.tictactoe.utils.Util;

public class Column {
    private Table table;
    private int column;

    public Column(Table table, int column) {
        this.table = table;
        this.column = column;
    }

    /**
     * Checks if this is a winning column
     * @return true if this is a winning column
     */
    public boolean isWon() {
        if (table.isCellOpen(0, column)) {
            return false;
        }

        return Util.equals(
                table.getCellDisplay(0, column),
                table.getCellDisplay(1, column),
                table.getCellDisplay(2, column));
    }
}
