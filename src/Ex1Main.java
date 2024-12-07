import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                System.out.println("num1= " + num1 + " is number: " + Ex1.isNumber(num1) + " ," + "value: " + Ex1.number2Int(num1));
            }
            if (!num2.equals("quit") && Ex1.isNumber(num1)) {
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();
                System.out.println("num2= " + num2 + " is number: " + Ex1.isNumber(num2) + " ," + "value: " + Ex1.number2Int(num2));
            }
            System.out.println("Enter a base for output: (a number [2,16]) ");
            int base = sc.nextInt();
            if (base < 2 || base > 16) {
                System.out.println("Invalid base! Base must be between 2 and 16.");
            }
            int num1Value = Ex1.number2Int(num1);
            int num2Value = Ex1.number2Int(num2);
            int sumValue = num1Value + num2Value;
            int multiplyValue = num1Value * num2Value;
            String sumInBase = Ex1.int2Number(sumValue, base);
            String multiplyInBase = Ex1.int2Number(multiplyValue, base);
            String arrOfValues[] = {num1,num2,sumInBase,multiplyInBase};
            System.out.println(num1 + " + " + num2 + "=" + sumInBase );
            System.out.println(num1 + " * " + num2 + "=" + multiplyInBase );
            System.out.println("Max number over [" + num1 + "," + num2 + "," + sumInBase + "," + multiplyInBase + "] is: " + Ex1.maxIndex(arrOfValues));
        }
        System.out.println("quiting now...");
    }
}