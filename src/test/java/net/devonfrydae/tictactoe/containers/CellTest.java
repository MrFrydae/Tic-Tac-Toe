package net.devonfrydae.tictactoe.containers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
    private Cell cell;

    @BeforeEach
    public void setup() {
        cell = new Cell();
    }

    @Test
    public void isFree() {
        assertTrue(cell.isFree());
    }

    @Test
    public void setPlayerAlreadyOwned() {
        cell.setComputerOwned();
        assertFalse(cell.setPlayerOwned());
    }

    @Test
    public void isPlayerOwned() {
        cell.setPlayerOwned();
        assertTrue(cell.isPlayerOwned());
    }

    @Test
    public void setComputerAlreadyOwned() {
        cell.setPlayerOwned();
        assertFalse(cell.setComputerOwned());
    }

    @Test
    public void isComputerOwned() {
        cell.setComputerOwned();
        assertTrue(cell.isComputerOwned());
    }

    @Test
    public void getDisplay() {
        assertEquals(' ', cell.getDisplay());

        cell.setPlayerOwned(true);
        assertEquals('X', cell.getDisplay());

        cell.setComputerOwned(true);
        assertEquals('O', cell.getDisplay());
    }
}