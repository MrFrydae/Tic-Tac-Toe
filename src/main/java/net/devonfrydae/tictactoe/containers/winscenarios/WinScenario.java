package net.devonfrydae.tictactoe.containers.winscenarios;

import net.devonfrydae.tictactoe.containers.Cell;

public abstract class WinScenario {
    public abstract char getWinner();

    public abstract boolean isWinnableByPlayer();

    public abstract boolean isWinnableByComputer();

    public abstract Cell getAvailableCell();
}
