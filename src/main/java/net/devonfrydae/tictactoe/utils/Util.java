package net.devonfrydae.tictactoe.utils;

public class Util {
    /**
     * Checks if the values of every provided object is equal
     *
     * @param objects A set of objects to verify
     * @return true if all provided objects are equal in value
     */
    public static boolean equals(Object... objects) {
        boolean equal = true;

        for (int i = 0; i < objects.length - 1; i++) {
            if (objects[i] != objects[i + 1]) {
                equal = false;
                break;
            }
        }

        return equal;
    }
}
