package net.devonfrydae.tictactoe.containers.winscenarios;

import net.devonfrydae.tictactoe.containers.Cell;
import net.devonfrydae.tictactoe.containers.Table;
import net.devonfrydae.tictactoe.utils.Util;

import java.util.stream.IntStream;

public class Diagonal extends WinScenario {
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

    @Override
    public boolean isWinnableByPlayer() {
        return isWinnable('X');
    }

    @Override
    public boolean isWinnableByComputer() {
        return isWinnable('O');
    }

    private boolean isWinnable(char type) {
        if (getAvailableCell() == null) {
            return false;
        }

        if (primary) {
            return Util.isAmountEqual(2, type,
                    table.getCellDisplay(0, 0),
                    table.getCellDisplay(1, 1),
                    table.getCellDisplay(2, 2));
        } else {
            return Util.isAmountEqual(2,  type,
                    table.getCellDisplay(0, 2),
                    table.getCellDisplay(1, 1),
                    table.getCellDisplay(2, 0));
        }
    }

    private Cell[] getCells() {
        Cell[] cells = new Cell[3];

        if (primary) {
            IntStream.range(0, 3).forEach(i -> cells[i] = table.getCell(i, i));
        } else {
            for (int i = 0, j = 2; i < 3 && j >= 0; i++, j--) {
                cells[i] = table.getCell(i, j);
            }
        }

        return cells;
    }

    @Override
    public Cell getAvailableCell() {
        for (Cell cell : getCells()) {
            if (cell.isFree()) {
                return cell;
            }
        }

        return null;
    }

    @Override
    public char getWinner() {
        if (isWon()) {
            return table.getCellDisplay(1, 1);
        }

        return ' '; // This should never be reached
    }
}
