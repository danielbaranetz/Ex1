import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (num1.equals(quit)) {
                break;
            }

            if (Ex1.isNumber(num1)) {
                System.out.println("num1= " + num1 + " is number: " + Ex1.isNumber(num1) + " ," + "value: " + Ex1.number2Int(num1));
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();

                if (num2.equals(quit)) {
                    break;
                }

                if (Ex1.isNumber(num2)) {
                    System.out.println("num2= " + num2 + " is number: " + Ex1.isNumber(num2) + " ," + "value: " + Ex1.number2Int(num2));
                    System.out.println("Enter a base for output: (a number [2,16]) ");
                    int base = sc.nextInt();
                    if (base < 2 || base > 16) {
                        System.out.println("(" + base + ") Invalid base! base must be between 2 and 16.");
                        continue;
                    }

                    int num1Value = Ex1.number2Int(num1);
                    int num2Value = Ex1.number2Int(num2);
                    int sumValue = num1Value + num2Value;
                    int multiplyValue = num1Value * num2Value;
                    String sumInBase = Ex1.int2Number(sumValue, base);
                    String multiplyInBase = Ex1.int2Number(multiplyValue, base);
                    String[] arrOfValues = {num1, num2, sumInBase, multiplyInBase};

                    int biggestNumberB10 = Ex1.maxIndex(arrOfValues);
                    String biggestNumberBase = Ex1.int2Number(biggestNumberB10, base);
                    System.out.println(num1 + " + " + num2 + " = " + sumInBase);
                    System.out.println(num1 + " * " + num2 + " = " + multiplyInBase);
                    System.out.println("Max number over [" + num1 + "," + num2 + "," + sumInBase + "," + multiplyInBase + "] is: " + biggestNumberBase);
                } else {
                    System.out.println("num2= " + num2 + "is number: " + Ex1.isNumber(num2) + ", value: " + Ex1.number2Int(num2));
                    System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                }
            } else {
                System.out.println("num1= " + num1 + "is number: " + Ex1.isNumber(num1) + ", value: " + Ex1.number2Int(num1));
                System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
            }
        }

        System.out.println("quiting now...");
    }
}
