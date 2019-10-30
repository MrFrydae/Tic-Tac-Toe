package net.devonfrydae.tictactoe.containers;

import net.devonfrydae.tictactoe.containers.winscenarios.Column;
import net.devonfrydae.tictactoe.containers.winscenarios.Diagonal;
import net.devonfrydae.tictactoe.containers.winscenarios.Row;
import net.devonfrydae.tictactoe.containers.winscenarios.WinScenario;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Float;
import java.util.ArrayList;
import java.util.List;

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
                    cells[row][column] = new Cell(row, column);
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
    public Cell getCell(int row, int column) {
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
        return getWinningScenario() != null;
    }

    private WinScenario getWinningScenario() {
        // Check for primary diagonal
        Diagonal primaryDiagonal = new Diagonal(this, true);
        if (primaryDiagonal.isWon()) {
            return primaryDiagonal;
        }

        // Check for secondary diagonal
        Diagonal secondaryDiagonal = new Diagonal(this, false);
        if (secondaryDiagonal.isWon()) {
            return secondaryDiagonal;
        }

        // Check for a winning row or colum
        for (int i = 0; i < 3; i++) {
            Row row = new Row(this, i);
            if (row.isWon()) {
                return row;
            }

            Column column = new Column(this, i);
            if (column.isWon()) {
                return column;
            }
        }

        return null;
    }

    /**
     * Gets the display character of the winner
     *
     * @return the winner of the game
     */
    public char getWinner() {
        WinScenario winScenario = getWinningScenario();
        if (winScenario == null) {
            return ' ';
        }

        return winScenario.getWinner();
    }

    /**
     * Clears the console and prints out the table
     */
    public void printTable() {
        System.out.print("\033[H\033[2J"); // Clear the text in console
        System.out.println(getCell(0, 0) + "|" + getCell(0, 1) + "|" + getCell(0, 2));
        System.out.println("-+-+-");
        System.out.println(getCell(1, 0) + "|" + getCell(1, 1) + "|" + getCell(1, 2));
        System.out.println("-+-+-");
        System.out.println(getCell(2, 0) + "|" + getCell(2, 1) + "|" + getCell(2, 2));
    }

    /**
     * @return a list of available cells in this table
     */
    public List<Cell> getOpenCells() {
        List<Cell> list = new ArrayList<>();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Cell cell = getCell(row, col);
                if (cell.isFree()) {
                    list.add(cell);
                }
            }
        }
        return list;
    }

    /**
     * @return true if this table is completely filled
     */
    public boolean isFull() {
        return getOpenCells().isEmpty();
    }
    
    public void drawTable(Graphics2D g) {
    	int min = 100; int max = 500; int minCenter = 233; int maxCenter = 367;
    	
    	Line2D topBorder = new Line2D.Float(min, min, max, min);
    	Line2D bottomBorder = new Line2D.Float(min, max, max, max);
    	Line2D leftBorder = new Line2D.Float(min, min, min, max);
    	Line2D rightBorder = new Line2D.Float(max, min, max, max);
    	
    	g.draw(topBorder);
    	g.draw(bottomBorder);
    	g.draw(leftBorder);
    	g.draw(rightBorder);
    	
    	Line2D topHorizontal = new Line2D.Float(min, minCenter, max, minCenter);
		Line2D bottomHorizontal = new Line2D.Float(min, maxCenter, max, maxCenter);
		Line2D leftVertical = new Line2D.Float(minCenter, min, minCenter, max);
		Line2D rightVertical = new Line2D.Float(maxCenter, min, maxCenter, max);
		
		g.draw(topHorizontal);
		g.draw(bottomHorizontal);
		g.draw(leftVertical);
		g.draw(rightVertical);
    }
}
