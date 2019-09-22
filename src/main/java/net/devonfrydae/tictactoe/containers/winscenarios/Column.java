package net.devonfrydae.tictactoe.containers.winscenarios;

import net.devonfrydae.tictactoe.containers.Cell;
import net.devonfrydae.tictactoe.containers.Table;
import net.devonfrydae.tictactoe.utils.Util;

import java.util.stream.IntStream;

public class Column extends WinScenario {
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
                table.getCellDisplay(0, column),
                table.getCellDisplay(1, column),
                table.getCellDisplay(2, column));
    }

    private Cell[] getCells() {
        Cell[] cells = new Cell[3];
        IntStream.range(0, 3).forEach(i -> cells[i] = table.getCell(i, column));
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
            return table.getCellDisplay(0, column);
        }

        return ' '; // This should never be reached
    }
}
