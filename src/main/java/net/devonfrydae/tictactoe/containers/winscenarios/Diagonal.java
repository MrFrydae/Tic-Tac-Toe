package net.devonfrydae.tictactoe.containers.winscenarios;

import net.devonfrydae.tictactoe.containers.Table;
import net.devonfrydae.tictactoe.utils.Util;

public class Diagonal {
    private Table table;
    private boolean primary;

    public Diagonal(Table table, boolean primary) {
        this.table = table;
        this.primary = primary;
    }

    /**
     * Checks if this is a winning diagonal
     *
     * @return true if this is a winning diagonal
     */
    public boolean isWon() {
        if (table.isCellOpen(1, 1)) {
            return false;
        }

        if (primary) {
            return Util.equals(
                    table.getCellDisplay(0, 0),
                    table.getCellDisplay(1, 1),
                    table.getCellDisplay(2, 2));
        } else {
            return Util.equals(
                    table.getCellDisplay(0, 2),
                    table.getCellDisplay(1, 1),
                    table.getCellDisplay(2, 0));
        }
    }
}
