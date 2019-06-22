import java.util.Scanner;
import java.text.DecimalFormat;

public class SciCalculator {

    public static void main(String[] args) {

        int operation = 0;
        boolean calc = true;
        boolean menuSelect;
        boolean goOn = true;
        double previousResult;
        double result = 0.0;
        double sumOfcalc = 0.0;
        int numOfcalc = 0;
        double firstOperand;
        double secondOperand;
        DecimalFormat deciLimit;
        deciLimit = new DecimalFormat("#.##");

        Scanner Scnr = new Scanner(System.in);
        while (calc) {

            menuSelect = true;

            System.out.println("Current Result: " + result);

            previousResult = result;

            result = 0.0;

            System.out.println(" ");
            System.out.println("Calculator Menu"); // Prints calculator operation menu
            System.out.println("---------------");
            System.out.println("0. Exit Program");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exponentiation");
            System.out.println("6. Logarithm");
            System.out.println("7. Display Average");
            System.out.println(" ");

            System.out.print("Enter Menu Selection: "); // Asks what operation user wants to perform


            while (menuSelect) {

                operation = Scnr.nextInt();
                if (operation >= 0 && operation <= 7) {
                    if (operation == 7) {
                        if (sumOfcalc == 0) {   // when there has not been a calculation done previously
                            System.out.println("Error: No calculations yet to average!");
                            System.out.print("Enter Menu Selection: ");
                        } else {    // when there has been a calculation done previously
                            System.out.println("Sum of calculations: " + deciLimit.format(sumOfcalc));
                            System.out.println("Number of calculations: " + numOfcalc);
                            System.out.println("Average of calculations: " + deciLimit.format((sumOfcalc / numOfcalc)));
                            System.out.print("Enter Menu Selection: ");
                        }
                    } else if (operation == 0) {  //  closes all loops ending program
                        System.out.print("Thanks for using this calculator. Goodbye!");
                        calc = false;
                        goOn = false;
                        break;
                    } else {
                        menuSelect = false;
                    }
                } else {  // when imputed operation selection is not in between [1,7]
                    System.out.println("Error: Invalid selection!");
                    System.out.println(" ");
                    System.out.print("Enter Menu Selection: ");
                }
            }

            if (goOn) {
                System.out.print("Enter first operand: ");

                String firstOperandString = Scnr.next();     // assigns string to operand

                if (firstOperandString.equals("RESULT")) {    // when input is "RESULT" the operand is equal to previous result total
                    firstOperand = previousResult;
                } else {
                    firstOperand = Double.parseDouble(firstOperandString); // when not "result" then the string is now a double
                }

                System.out.print("Enter second operand:");

                String SecondOperandString = Scnr.next();

                if (SecondOperandString.equals("RESULT")) {
                    secondOperand = previousResult;
                } else {
                    secondOperand = Double.parseDouble(SecondOperandString);
                }

                if (operation == 1) {
                    result = (firstOperand + secondOperand);
                } else if (operation == 2) {
                    result = (firstOperand - secondOperand);
                } else if (operation == 3) {
                    result = (firstOperand * secondOperand);
                } else if (operation == 4) {
                    result = (firstOperand / secondOperand);
                } else if (operation == 5) {
                    result = Math.pow(firstOperand, secondOperand);
                } else if (operation == 6) {
                    result = (Math.log(secondOperand) / Math.log(firstOperand));
                }

                sumOfcalc = (sumOfcalc + result);  // total amount that has been calculated while using calc
                numOfcalc = numOfcalc + 1;   // adds 1 to number of times used

            }
        }
    }
}

