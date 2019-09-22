package net.devonfrydae.tictactoe.containers.winscenarios;

import net.devonfrydae.tictactoe.containers.Cell;
import net.devonfrydae.tictactoe.containers.Table;
import net.devonfrydae.tictactoe.utils.Util;

import java.util.stream.IntStream;

public class Row extends WinScenario {
    private Table table;
    private Cell[] cells = new Cell[3];
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

        return Util.isAmountEqual(2, type,
                table.getCellDisplay(row, 0),
                table.getCellDisplay(row, 1),
                table.getCellDisplay(row, 2));
    }

    private Cell[] getCells() {
        Cell[] cells = new Cell[3];
        IntStream.range(0, 3).forEach(i -> cells[i] = table.getCell(row, i));
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
            return table.getCellDisplay(row, 0);
        }

        return ' '; // This should never be reached
    }
}
