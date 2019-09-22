package net.devonfrydae.tictactoe;

import net.devonfrydae.tictactoe.containers.Table;
import net.devonfrydae.tictactoe.containers.winscenarios.Column;
import net.devonfrydae.tictactoe.containers.winscenarios.Diagonal;
import net.devonfrydae.tictactoe.containers.winscenarios.Row;
import net.devonfrydae.tictactoe.containers.winscenarios.WinScenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Table table;

    /**
     * Initializes the table, prints the table, and starts the player's turn
     */
    public Game() {
        table = new Table();
        table.printTable();

        playersTurn();
    }

    /**
     * Starts the player's turn
     */
    void playersTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("It's your turn, please enter a row and column");

        boolean played = false;
        boolean firstLoop = true;

        while (!played) {
            if (!firstLoop) {
                System.out.println("That cell is already taken. Please choose another one");
            }

            int row = scanner.nextInt() - 1;
            int column = scanner.nextInt() - 1;

            if (table.isCellOwned(row, column)) {
                firstLoop = false;
                continue;
            } else {
                table.setPlayerOwned(row, column);
            }

            played = true;
        }
        table.printTable();

        if (table.isFull()) {
            gameDraw();
            scanner.close();
            return;
        }

        if (table.isWon()) {
            gameWon();
            scanner.close();
        } else {
            Computer computer = new Computer(this);
            computer.playBestMove();
        }
    }

    void gameWon() {
        char winner = table.getWinner();

        if (winner == ' ') {
            System.out.println("Something really bad happened... Try playing another game");
        } else if (winner == 'X') {
            System.out.println("Congratulations!!! You have won against a computer :)");
        } else if (winner == 'O') {
            System.out.println("You lost. Don't feel too bad, this usually happens");
        }
    }

    void gameDraw() {
        System.out.println("Nobody won this game.. Sorry about your luck");
    }

    /**
     * Gets the table
     *
     * @return this game's table
     */
    public Table getTable() {
        return table;
    }

    /**
     * @return true if the player can win this game
     */
    public boolean isWinnableByPlayer() {
        return getWinScenarios().stream().anyMatch(WinScenario::isWinnableByPlayer);
    }

    /**
     * @return true if the computer can win this game
     */
    public boolean isWinnableByComputer() {
        return getWinScenarios().stream().allMatch(WinScenario::isWinnableByComputer);
    }

    List<WinScenario> getWinScenarios() {
        List<WinScenario> scenarios = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            scenarios.add(new Column(getTable(), i));
            scenarios.add(new Row(getTable(), i));
        }
        scenarios.add(new Diagonal(getTable(), true));
        scenarios.add(new Diagonal(getTable(), false));

        return scenarios;
    }
}
