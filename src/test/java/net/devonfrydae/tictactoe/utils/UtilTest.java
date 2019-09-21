package net.devonfrydae.tictactoe.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilTest {
    @Test
    public void testEquals() {
        assertTrue(Util.equals("5", "5", "5", "5"));
        assertTrue(Util.equals(5, 5, 5, 5));
        assertTrue(Util.equals(true, true, true, true));
        assertFalse(Util.equals("1", "2", "3", "4"));
        assertFalse(Util.equals(1, 2, 3, 4));
        assertFalse(Util.equals(true, false, true, false));
    }
}