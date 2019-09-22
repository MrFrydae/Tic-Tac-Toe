package net.devonfrydae.tictactoe.containers.winscenarios;

import net.devonfrydae.tictactoe.containers.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ColumnTest {
    private Table table;

    @BeforeEach
    public void setup() {
        table = new Table();
    }

    @Test
    public void testWinning() {
        Column column = new Column(table, 0);

        table.setComputerOwned(0, 0);
        table.setComputerOwned(1, 0);
        assertFalse(column.isWon());

        table.setComputerOwned(2, 0);
        assertTrue(column.isWon());
    }

    @Test
    public void testWinnableByPlayer() {
        Column column = new Column(table, 0);

        table.setPlayerOwned(0, 0);
        assertFalse(column.isWinnableByPlayer());

        table.setPlayerOwned(1, 0);
        assertTrue(column.isWinnableByPlayer());

        table.setComputerOwned(2, 0);
        assertFalse(column.isWinnableByPlayer());
    }

    @Test
    public void testWinnableByComputer() {
        Column column = new Column(table, 0);

        table.setComputerOwned(0, 0);
        assertFalse(column.isWinnableByComputer());

        table.setComputerOwned(1, 0);
        assertTrue(column.isWinnableByComputer());

        table.setPlayerOwned(2, 0);
        assertFalse(column.isWinnableByComputer());
    }
}
