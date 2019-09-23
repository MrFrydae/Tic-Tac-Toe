package net.devonfrydae.tictactoe;

import net.devonfrydae.tictactoe.utils.OptionManager;

public class TicTacToe {
    private static OptionManager optionManager;

    public static void main(String[] args) {
        optionManager = OptionManager.getSingleton();

        setOptions(args);

        new Game();
    }

    /**
     * Initializes different settings for the program
     *
     * @param args the input arguments for the program
     */
    private static void setOptions(String[] args) {
        for (String arg : args) {
            switch (arg) {
                case "-a":
                case "--advanced":
                    optionManager.setAdvancedMode(true);
                    break;
                default:
                    // I need this because checkstyle complains
                    break;
            }
        }
    }
}
