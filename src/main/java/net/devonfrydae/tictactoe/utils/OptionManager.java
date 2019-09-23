package net.devonfrydae.tictactoe.utils;

public class OptionManager {
    private static OptionManager singleton;
    private boolean advancedMode;

    /**
     * @return the singleton object for this class
     */
    public static OptionManager getSingleton() {
        if (singleton == null) {
            singleton = new OptionManager();
        }

        return singleton;
    }

    /**
     * @return true if this game is in advanced mode
     */
    public boolean isAdvancedMode() {
        return advancedMode;
    }

    /**
     * Sets the advanced mode
     *
     * @param advancedMode should we play the advanced version
     */
    public void setAdvancedMode(boolean advancedMode) {
        this.advancedMode = advancedMode;
    }
}
