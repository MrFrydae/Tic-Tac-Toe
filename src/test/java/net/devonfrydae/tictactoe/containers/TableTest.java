package net.devonfrydae.tictactoe.containers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableTest {
    private Table table;

    @BeforeEach
    public void setup() {
        table = new Table();
    }

    @Test
    public void testIsWon() {
        assertFalse(table.isWon());
    }

    // <editor-fold desc="Test Diagonals" defaultstate="collapsed">
    @Test
    public void testIsWonPrimaryDiagonal() {
        table.setPlayerOwned(0, 0);
        table.setPlayerOwned(1, 1);
        table.setPlayerOwned(2, 2);
        assertTrue(table.isWon());
    }

    @Test
    public void testIsNotWonPrimaryDiagonal() {
        table.setPlayerOwned(0, 0);
        table.setComputerOwned(1, 1);
        table.setPlayerOwned(2, 2);
        assertFalse(table.isWon());
    }

    @Test
    public void testIsWonSecondaryDiagonal() {
        table.setComputerOwned(0, 2);
        table.setComputerOwned(1, 1);
        table.setComputerOwned(2, 0);
        assertTrue(table.isWon());
    }

    @Test
    public void testIsNotWonSecondaryDiagonal() {
        table.setComputerOwned(0, 2);
        table.setPlayerOwned(1, 1);
        table.setComputerOwned(2, 0);
        assertFalse(table.isWon());
    }
    // </editor-fold>

    // <editor-fold desc="Test Rows" defaultstate="collapsed">
    @Test
    public void testIsWonRow() {
        table.setPlayerOwned(0, 0);
        table.setPlayerOwned(0, 1);
        table.setPlayerOwned(0, 2);
        assertTrue(table.isWon());
    }

    @Test
    public void testIsNotWonRow() {
        table.setComputerOwned(1, 0);
        table.setPlayerOwned(1, 1);
        table.setComputerOwned(1, 2);
        assertFalse(table.isWon());
    }
    // </editor-fold>

    // <editor-fold desc="Test Columns" defaultstate="collapsed">
    @Test
    public void testIsWonColumn() {
        table.setComputerOwned(0, 0);
        table.setComputerOwned(1, 0);
        table.setComputerOwned(2, 0);
        assertTrue(table.isWon());
    }

    @Test
    public void testIsNotWonColumn() {
        table.setPlayerOwned(0, 0);
        table.setComputerOwned(1, 0);
        table.setPlayerOwned(2, 0);
        assertFalse(table.isWon());
    }
    // </editor-fold>
}
