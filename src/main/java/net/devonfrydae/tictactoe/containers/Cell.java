package net.devonfrydae.tictactoe.containers;

public class Cell {
    private CellState type;

    /**
     * Initializes this object as an unowned cell
     */
    public Cell() {
        this.type = CellState.FREE;
    }

    /**
     * Checks if this cell is owned by anyone
     *
     * @return true if this cell is unowned
     */
    public boolean isFree() {
        return type == CellState.FREE;
    }

    /**
     * Checks if the player owns this cell
     *
     * @return true if this cell is owned by the player
     */
    public boolean isPlayerOwned() {
        return type == CellState.PLAYER;
    }

    /**
     * Sets this cell to be owned by the player
     *
     * @return true if this cell was set correctly, and
     *         will return false if this cell is already owned
     */
    public boolean setPlayerOwned() {
        return setPlayerOwned(false);
    }

    /**
     * Sets this cell to be owned by the player
     *
     * @param force overwrite any ownership over this cell
     * @return true if the cell was set correctly, and
     *         will return false if this cell is already owned
     */
    boolean setPlayerOwned(boolean force) {
        if (!force) {
            if (isFree()) {
                type = CellState.PLAYER;
                return true;
            } else {
                return false;
            }
        } else {
            type = CellState.PLAYER;
            return true;
        }
    }

    /**
     * Checks if the computer owns this cell
     *
     * @return true if this cell is owned by the computer
     */
    public boolean isComputerOwned() {
        return type == CellState.COMPUTER;
    }

    /**
     * Sets this cell to be owned by the computer
     *
     * @return true if the cell was set correctly, and
     *         will return false if this cell is already owned
     */

    public boolean setComputerOwned() {
        return setComputerOwned(false);
    }

    /**
     * Sets this cell to be owned by the computer
     *
     * @param force overwrite any ownership over this cell
     * @return true if the cell was set correctly, and
     *         will return false if this cell is already owned
     */

    boolean setComputerOwned(boolean force) {
        if (!force) {
            if (isFree()) {
                type = CellState.COMPUTER;
                return true;
            } else {
                return false;
            }
        } else {
            type = CellState.COMPUTER;
            return true;
        }
    }

    /**
     * Gets the character to be displayed for this cell
     *
     * @return the symbol for this cell
     */
    public char getDisplay() {
        return type.symbol;
    }

    private enum CellState {
        COMPUTER('O'), FREE(' '), PLAYER('X');

        char symbol;

        CellState(char symbol) {
            this.symbol = symbol;
        }
    }
}