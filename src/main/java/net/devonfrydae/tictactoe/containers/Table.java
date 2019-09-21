package net.devonfrydae.tictactoe.containers;

import net.devonfrydae.tictactoe.containers.winscenarios.Column;
import net.devonfrydae.tictactoe.containers.winscenarios.Diagonal;
import net.devonfrydae.tictactoe.containers.winscenarios.Row;

public class Table {
    private Cell[][] cells = new Cell[3][3];

    /**
     * Initializes all values in the cells array
     */
    public Table() {
        // <editor-fold desc="Initialize Cells" defaultstate="collapsed">
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (cells[row][column] == null) {
                    cells[row][column] = new Cell();
                }
            }
        }
        // </editor-fold>
    }

    /**
     * Gets the requested {@link Cell}
     *
     * @param row the row to find
     * @param column the column to find
     * @return the cell at the provided location
     */
    private Cell getCell(int row, int column) {
        return cells[row][column];
    }

    /**
     * Checks if the player owns this cell
     *
     * @return true if this cell is owned by the player
     */
    public boolean isPlayerOwned(int row, int column) {
        return getCell(row, column).isPlayerOwned();
    }

    /**
     * Sets this cell to be owned by the player
     *
     * @return true if the cell was set correctly, and
     *         will return false if this cell is already owned
     */
    public boolean setPlayerOwned(int row, int column) {
        return setPlayerOwned(row, column, false);
    }

    /**
     * Sets this cell to be owned by the player
     *
     * @param force overwrite any ownership over this cell
     * @return true if the cell was set correctly, and
     *         will return false if this cell is already owned
     */
    boolean setPlayerOwned(int row, int column, boolean force) {
        return getCell(row, column).setPlayerOwned(force);
    }

    /**
     * Checks if the computer owns this cell
     *
     * @return true if this cell is owned by the computer
     */
    public boolean isComputerOwned(int row, int column) {
        return getCell(row, column).isComputerOwned();
    }

    /**
     * Sets this cell to be owned by the computer
     *
     * @return true if the cell was set correctly, and
     *         will return false if this cell is already owned
     */
    public boolean setComputerOwned(int row, int column) {
        return setComputerOwned(row, column, false);
    }

    /**
     * Sets this cell to be owned by the computer
     *
     * @param force overwrite any ownership over this cell
     * @return true if the cell was set correctly, and
     *         will return false if this cell is already owned
     */
    private boolean setComputerOwned(int row, int column, boolean force) {
        return getCell(row, column).setComputerOwned(force);
    }

    /**
     * Gets the display character for the requested cell
     *
     * @param row the row to find
     * @param column the column to find
     * @return the {@link Cell cell}'s display character
     */
    public char getCellDisplay(int row, int column) {
        return getCell(row, column).getDisplay();
    }

    /**
     * Checks if the requested cell is owned
     *
     * @param row the row to check
     * @param column the column to check
     * @return true if the cell is owned
     */
    public boolean isCellOwned(int row, int column) {
        return !isCellOpen(row, column);
    }

    /**
     * Checks if the requested cell is not owned
     *
     * @param row the row to check
     * @param column the column to check
     * @return true if the cell is not owned
     */
    public boolean isCellOpen(int row, int column) {
        return getCell(row, column).isFree();
    }

    /**
     * Searches this table for any winning combinations
     *
     * @return true if this is a winning table
     */
    public boolean isWon() {
        // Check if any diagonals are valid
        if (new Diagonal(this, true).isWon()) {
            return true;
        }

        if (new Diagonal(this, false).isWon()) {
            return true;
        }

        // Check for a winning row or column
        for (int i = 0; i < 3; i++) {
            if (new Row(this, i).isWon()) {
                return true;
            }

            if (new Column(this, i).isWon()) {
                return true;
            }
        }

        return false;
    }
}
