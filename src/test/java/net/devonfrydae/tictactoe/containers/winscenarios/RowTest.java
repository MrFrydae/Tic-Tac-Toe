package net.devonfrydae.tictactoe.containers.winscenarios;

import net.devonfrydae.tictactoe.containers.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RowTest {
    private Table table;

    @BeforeEach
    public void setup() {
        table = new Table();
    }

    @Test
    public void testWinning() {
        Row row = new Row(table, 0);

        table.setComputerOwned(0, 2);
        table.setComputerOwned(0, 1);
        assertFalse(row.isWon());

        table.setComputerOwned(0, 0);
        assertTrue(row.isWon());
    }

    @Test
    public void testWinnableByPlayer() {
        Row row = new Row(table, 0);

        table.setPlayerOwned(0, 0);
        assertFalse(row.isWinnableByPlayer());

        table.setPlayerOwned(0, 1);
        assertTrue(row.isWinnableByPlayer());

        table.setComputerOwned(0, 2);
        assertFalse(row.isWinnableByPlayer());
    }

    @Test
    public void testWinnableByComputer() {
        Row row = new Row(table, 0);

        table.setComputerOwned(0, 0);
        assertFalse(row.isWinnableByComputer());

        table.setComputerOwned(0, 1);
        assertTrue(row.isWinnableByComputer());

        table.setPlayerOwned(0, 2);
        assertFalse(row.isWinnableByComputer());
    }
}
