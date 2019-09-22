package net.devonfrydae.tictactoe;

import net.devonfrydae.tictactoe.containers.Cell;
import net.devonfrydae.tictactoe.containers.Table;
import net.devonfrydae.tictactoe.containers.winscenarios.WinScenario;

import java.util.List;
import java.util.Random;

public class Computer {
    private Game game;
    private Table table;

    public Computer(Game game) {
        this.game = game;
        this.table = game.getTable();
    }

    /**
     * Finds and plays the best possible move
     */
    public void playBestMove() {
        Move bestMove = getBestMove();
        bestMove.play();

        table.printTable();

        if (getTable().isFull()) {
            getGame().gameDraw();
            return;
        }

        if (getTable().isWon()) {
            getGame().gameWon();
            return;
        }

        game.playersTurn();
    }

    private Move getBestMove() {
        if (game.isWinnableByComputer()) {
            for (WinScenario scenario : game.getWinScenarios()) {
                if (scenario.isWinnableByComputer()) {
                    return new Move(scenario.getAvailableCell());
                }
            }
        }

        if (game.isWinnableByPlayer()) {
            for (WinScenario scenario : game.getWinScenarios()) {
                if (scenario.isWinnableByPlayer()) {
                    return new Move(scenario.getAvailableCell());
                }
            }
        }

        List<Cell> openCells = getGame().getTable().getOpenCells();
        return new Move(openCells.get(new Random().nextInt(openCells.size())));
    }

    private Game getGame() {
        return game;
    }

    private Table getTable() {
        return table;
    }

    private static class Move {
        private Cell cell;

        public Move(Cell cell) {
            this.cell = cell;
        }

        public void play() {
            cell.setComputerOwned();
        }
    }
}
