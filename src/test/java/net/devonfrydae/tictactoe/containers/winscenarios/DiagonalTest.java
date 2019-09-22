package net.devonfrydae.tictactoe.containers.winscenarios;

import net.devonfrydae.tictactoe.containers.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiagonalTest {
    private Table table;

    @BeforeEach
    public void setup() {
        table = new Table();
    }

    @Test
    public void testWinningPrimary() {
        Diagonal primary = new Diagonal(table, true);

        table.setComputerOwned(0, 0);
        table.setComputerOwned(1, 1);
        assertFalse(primary.isWon());

        table.setComputerOwned(2, 2);
        assertTrue(primary.isWon());
    }

    @Test
    public void testWinningSecondary() {
        Diagonal secondary = new Diagonal(table, false);

        table.setComputerOwned(0, 2);
        table.setComputerOwned(1, 1);
        assertFalse(secondary.isWon());

        table.setComputerOwned(2, 0);
        assertTrue(secondary.isWon());
    }

    @Test
    public void testPrimaryWinnableByPlayer() {
        Diagonal primary = new Diagonal(table, true);

        table.setPlayerOwned(0, 0);
        assertFalse(primary.isWinnableByPlayer());

        table.setPlayerOwned(1, 1);
        assertTrue(primary.isWinnableByPlayer());

        table.setComputerOwned(2, 2);
        assertFalse(primary.isWinnableByPlayer());
    }

    @Test
    public void testSecondaryWinnableByPlayer() {
        Diagonal secondary = new Diagonal(table, false);

        table.setPlayerOwned(0, 2);
        assertFalse(secondary.isWinnableByPlayer());

        table.setPlayerOwned(1, 1);
        assertTrue(secondary.isWinnableByPlayer());

        table.setComputerOwned(2, 0);
        assertFalse(secondary.isWinnableByPlayer());
    }

    @Test
    public void testPrimaryWinnableByComputer() {
        Diagonal primary = new Diagonal(table, true);

        table.setComputerOwned(0, 0);
        assertFalse(primary.isWinnableByComputer());

        table.setComputerOwned(1, 1);
        assertTrue(primary.isWinnableByComputer());

        table.setPlayerOwned(2, 2);
        assertFalse(primary.isWinnableByComputer());
    }

    @Test
    public void testSecondaryWinnableByComputer() {
        Diagonal secondary = new Diagonal(table, false);

        table.setComputerOwned(0, 2);
        assertFalse(secondary.isWinnableByComputer());

        table.setComputerOwned(1, 1);
        assertTrue(secondary.isWinnableByComputer());

        table.setPlayerOwned(2, 0);
        assertFalse(secondary.isWinnableByComputer());
    }
}
