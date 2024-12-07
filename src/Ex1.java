
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        if (num == null || num.isEmpty()) {
            return -1;  // Invalid format
        }

        String number;
        String baseStr;
        int base;

        // Check if the input contains 'b'
        if (num.contains("b")) {
            String[] parts = num.split("b");
            if (parts.length != 2) {
                return -1;  // Invalid format
            }
            number = parts[0];
            baseStr = parts[1];

            // Determine the base
            if (baseStr.equals("A")) base = 10;
            else if (baseStr.equals("B")) base = 11;
            else if (baseStr.equals("C")) base = 12;
            else if (baseStr.equals("D")) base = 13;
            else if (baseStr.equals("E")) base = 14;
            else if (baseStr.equals("F")) base = 15;
            else if (baseStr.equals("G")) base = 16;
            else {
                if (!isValidNumericBase(baseStr)) {
                    return -1; // Invalid base format
                }
                base = Integer.parseInt(baseStr); // Convert to an integer
            }
        } else {
            // Default base 10
            number = num;
            base = 10;
        }

        // Convert the number part to decimal
        int result = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            int digit = Character.digit(c, base); // Converts character to digit in the given base
            if (digit == -1) {
                return -1; // Invalid character for the given base
            }
            result = result * base + digit;
        }

        return result;
    }

    private static boolean isValidNumericBase(String baseStr) {
        // Check if baseStr contains only digits and the range [2, 9]
        if (baseStr.isEmpty()) {
            return false;
        }
        for (int i = 0; i < baseStr.length(); i++) {
            if (!Character.isDigit(baseStr.charAt(i))) {
                return false;
            }
        }
        int base = Integer.parseInt(baseStr);
        return base >= 2 && base <= 9;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        if (number2Int(a) == -1) {
            return !ans;
        } else {
            return ans;
        }
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        if (num <= 0 || base < 2 || base > 16) return "";
        String number = Integer.toString(num, base);
        String baseStr;
        if (base >= 10) {
            baseStr = String.valueOf((char) ('A' + (base - 10)));
        } else {
            baseStr = String.valueOf(base);
        }        if (base == 10) {
            return number;
        }
        return number + "b" + baseStr;
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here

        ////////////////////
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int biggestNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            int value = Ex1.number2Int(arr[i]);
            if (value > biggestNumber) {
                biggestNumber = value;
            }
        }
        return biggestNumber;

    }
}