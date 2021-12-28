import java.util.Scanner;

/**
 * This program creates a Binary and Hexadecimal Calculator based off of two online applications
 * @see <a href="https://www.calculator.net/binary-calculator.html"> The binary Calculator </a>
 * and @see <a href= "https://www.calculator.net/hex-calculator.html">The Hexadecimal Calculator</a>
 * using OOP constructs of JAVA
 */
public class oopCalculator {
    /**
     * This is the main method of the program. It gets input from the user of
     * which calculation to make with either binary or hexadecimal values and outputs the outcome
     * to the user.
     */
    public static void main(String[] args){
        System.out.println("Hello! Welcome to the Binary and Hexadecimal Calculator.");  //asking for the binary or hexadecimal calculator
        System.out.println("Enter 'b' for binary or 'h' for hexadecimal.");

        Scanner input = new Scanner(System.in); // input for either binary or hex
        char binOrHex = input.next().charAt(0);  //getting the character

        if(binOrHex == 'b'){

            System.out.println("Binary calculator\n1: Compute a Binary Calculation");   // the three calculations available
            System.out.println("2: Convert a Binary Number to a Decimal Value");
            System.out.println("3: Convert a Decimal Value to a Binary Number\nEnter 1,2, or 3:");

            int choiceNum = input.nextInt();

            switch(choiceNum){   // choosing a calculation based on input
                case 1:
                    System.out.println("Enter First Binary Number");  //getting more input
                    String firstBinary = input.next();
                    System.out.println("Enter + - * or /");
                    char symbol = input.next().charAt(0);
                    System.out.println("Enter Second Binary Number:");
                    String secondBinary = input.next();

                    int binary1 = Integer.parseInt(firstBinary,2);
                    int binary2 = Integer.parseInt(secondBinary,2);  //converting binary to decimal

                    int total = getTotal(symbol, binary1, binary2); //calling the method to calculate the output

                    boolean negative = false;
                    if(total < 0){  //checking to see if it is a negative result
                        total = total * -1;
                        negative  = true;
                    }

                    if(negative)
                        System.out.print("-");

                    System.out.print(Integer.toBinaryString(total)); //outputting back to binary

                    if(symbol == '/'){
                        int remainder = binary1 % binary2; //getting the remainder
                        System.out.println(" remainder " + Integer.toBinaryString(remainder));}break;

                case 2:
                    System.out.println("Enter Binary Value to Convert to Decimal Value:");
                    String binary = input.next();
                    System.out.println(Integer.parseInt(binary, 2));break;  //converting binary to decimal
                case 3:
                    System.out.println("Enter Decimal Value to Convert to Binary Value:");
                    int decNum = input.nextInt();
                    System.out.println(Integer.toBinaryString(decNum));break;  //converting decimal to binary
            }
        }else if(binOrHex == 'h'){

            System.out.println("Hexadecimal calculator\n1: Compute a Hexadecimal Calculation"); //creating the hexadecimal calculator
            System.out.println("2: Convert a Hexadecimal Number to a Decimal Value");
            System.out.println("3: Convert a Decimal Value to a Hexadecimal Number\nEnter 1,2, or 3:");

            int choiceNum = input.nextInt();

            switch(choiceNum){    //choosing a calculation based on input
                case 1:
                    System.out.println("Enter first Hexadecimal Value:");  //getting more input
                    String firstHex = input.next();
                    System.out.println("Enter + - * or /");
                    char symbol = input.next().charAt(0);
                    System.out.println("Enter Second Hexadecimal Value:");
                    String secondHex = input.next();

                    int decHex1 = Integer.parseInt(firstHex,16);  //converting to decimal
                    int decHex2 = Integer.parseInt(secondHex, 16);

                    int total = getTotal(symbol, decHex1, decHex2);  //calling the method to calculate the output

                    boolean negative = false;
                    if(total < 0){  //checking to see if it is a negative result
                        total = total * -1;
                        negative  = true;
                    }

                    if(negative)
                        System.out.print("-");

                    System.out.print(Integer.toHexString(total).toUpperCase()); //outputting back to hexadecimal

                    if(symbol == '/'){
                        int remainder = decHex1 % decHex2; //getting the remainder
                        System.out.println(" remainder " + Integer.toHexString(remainder));}break;

                case 2:
                    System.out.println("Enter Hexadecimal Values to Convert to Decimal Value:");
                    String hexStr = input.next();
                    System.out.println(Integer.parseInt(hexStr, 16));break;  //converting to decimal
                case 3:
                    System.out.println("Enter a Decimal to Convert to a HexaDecimal Value:");
                    String decimalS = input.next();

                    if(decimalS.charAt(0) == '-') {
                        System.out.print("-");
                        decimalS = decimalS.substring(1);
                    }

                    int decimal = Integer.parseInt(decimalS);

                    System.out.println(Integer.toHexString(decimal).toUpperCase());break;  //converting to hexadecimal
            }
        }
    }

    /**
     * This method receives input from the user and completes a calculation with the input
     * @param symbol  which type of calculation to complete: either + - * /
     * @param decimal1 the integer in the calculation
     * @param decimal2 the second integer in the calculation
     * @return the output of the calculation
     */
    public static int getTotal(char symbol, int decimal1, int decimal2) { //method to calculate the output based upon symbol input
        int total = 0;
        if(symbol == '+'){   //completing a calculation
            total = decimal1 + decimal2;
        }else if(symbol == '-'){
            total = decimal1 - decimal2;
        }else if(symbol == '*'){
            total = decimal1 * decimal2;
        }else if(symbol == '/')
            total = decimal1 / decimal2;

        return total;
    }
}