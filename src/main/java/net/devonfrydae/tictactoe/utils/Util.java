package net.devonfrydae.tictactoe.utils;

public class Util {
    /**
     * Checks if the values of every provided object is equal
     *
     * @param objects A set of objects to verify
     * @return true if all provided objects are equal in value
     */
    public static boolean equals(Object... objects) {
        return isAmountEqual(objects.length, objects[0], objects);
    }

    /**
     * Searches the inputted objects for a certain amount of equal values
     *
     * @param amount the amount of elements that need to be equal
     * @param equalTo the value to check for
     * @param objects a set of objects to validate
     * @return true if there are at least <code>amount</code> equal objects
     */
    public static boolean isAmountEqual(int amount, Object equalTo, Object... objects) {
        int equal = 0;

        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(equalTo)) {
                equal++;
            }
        }

        return equal >= amount;
    }
}
