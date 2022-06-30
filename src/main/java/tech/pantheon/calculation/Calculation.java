package tech.pantheon.calculation;

import java.math.BigInteger;

public class Calculation {

    public static void main(String[] args) {

        // If statement checks, if we used 3 parameters (algo,num1,num2)
        if(args.length == 3) {
            // Switch checks first parameter - which algo. to use
            switch (args[0]){
                // First implementation - BigInteger
                case "--alg1" : {
                    // checks if two numbers are digits
                    if(isNumeric(args[1]) && isNumeric(args[2])){
                        // calling first method algo1
                        printObject(algo1(new BigInteger(args[1]),new BigInteger(args[2])));
                    }else System.out.println("Wrong parameters.");
                    break;
                }
                // Second implementation - Custom
                case "--alg2" : {
                    // checks if two numbers are digits
                    if(isNumeric(args[1]) && isNumeric(args[2])){
                        // calling second method algo2
                        printObject(algo2(args[1],args[2]));
                    }else System.out.println("Wrong parameters.");
                    break;
                }
                // Message : When we have wrong first parameter
                default : {
                    System.out.println("First parameter is wrong.");
                    break;
                }
            }
            // Message : When we have less or greater than 3 parameters
        }else System.out.println("Wrong parameters.");
    }

    /**
     * Method checks if parameter is digit
     * @param str is type - String
     * @return Boolean
     */
    static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Prints result of our algorithms : algo1 or algo2
     * @return Nothing
     * @param object might be String or BigInteger
     */
    static void printObject(Object object){
        System.out.println(object);
    }

    /**
     * Method multiplies two numbers that are represented as BigIntegers
     * @return BigInteger
     * @param num1 is first number as BigInteger
     * @param num2 is second number as BigInteger
     */
    static BigInteger algo1(BigInteger num1, BigInteger num2) {
        return num1.multiply(num2);
    }

    /**
     * Method multiplies two numbers that are represented as Strings
     * @return String
     * @param num1 is first number as String
     * @param num2 is second number as String
     */
    static String algo2(String num1, String num2) {
        // Length of nums
        int len1 = num1.length(), len2 = num2.length();
        // Array that holds results
        int [] values = new int[len1 + len2];
        // Loop from right to left of our num1
        for(int i = len1 -1; i >= 0; --i) {
            // Loop from right to left of our num2
            for (int j = len2 - 1; j >= 0; --j) {
                // Multiplication of digits converted from ASCII
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // Product of values that are already stored in values array
                int sum = values[i + j + 1] + mul;
                // Storing results to our array
                values[i + j] += sum / 10;
                values[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        // Results of our array converted to StringBuilder
        for(int val : values) {
            if(sb.length() != 0 || val != 0) {
                sb.append(val);
            }
        }
        // Returning results of our multiplication in String.
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
