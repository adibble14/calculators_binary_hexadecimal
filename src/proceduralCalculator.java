import java.util.Scanner;

/**
 * This program creates a Binary and Hexadecimal Calculator based off of two online applications
 * @see <a href="https://www.calculator.net/binary-calculator.html"> The binary Calculator </a>
 * and @see <a href= "https://www.calculator.net/hex-calculator.html">The Hexadecimal Calculator</a>
 * using only the procedural constructs of JAVA
 */
public class proceduralCalculator {
    /**
     * This is the main method of the program. It gets input from the user of which method to call and
     * which calculation to make.
     */
    public static void main(String[] args){

        System.out.println("Hello! Welcome to the Binary and Hexadecimal Calculator.");
        System.out.println("Enter 'b' for binary or 'h' for hexadecimal.");

        Scanner input = new Scanner(System.in); // input for either binary or hex
        char binOrHex = input.next().charAt(0);  //getting the character

        if(binOrHex == 'b'){   //if binary, calling the binary or hex calculator

            System.out.println("Binary calculator");  //creating the binary calculator

            System.out.println("1: Compute a Binary Calculation");
            System.out.println("2: Convert a Binary Number to a Decimal Value");
            System.out.println("3: Convert a Decimal Value to a Binary Number");

            System.out.println("Enter 1,2, or 3:");
            Scanner options = new Scanner(System.in);  //getting the input for what method to call
            int choiceNum = options.nextInt();

            switch(choiceNum){  //calling a certain method based on the input
                case 1: calcBinary(); break;
                case 2:
                    System.out.println("Enter Binary Value to Convert to Decimal Value:"); //calling the method to convert binary to decimal
                    Scanner binaryInput = new Scanner(System.in);
                    int binary = binaryInput.nextInt();

                    int decimalValue = convertBinary(binary);

                    System.out.println(decimalValue); //output
                    break;
                case 3:
                    System.out.println("Enter Decimal Value to Convert to Binary Value:"); //getting input for converter
                    Scanner decInput = new Scanner(System.in);
                    int decNum = decInput.nextInt();
                    boolean negative = false;

                    if(decNum < 0){   //if negative, make it positive
                        decNum = decNum * -1;
                        negative = true;
                    }

                    int binaryNum[] = convertDecimalB(decNum);  //calling method
                    int i = binaryNum[0];

                    if(negative){    //if negative then add a -
                        System.out.print("-"); //output
                    }

                    for (int j = i; j >= 1; j--) {  // printing binary array in reverse order
                        System.out.print(binaryNum[j]);
                    }
                    break;
            }

        }else if(binOrHex == 'h'){  //if hexadecimal
            System.out.println("Hexadecimal calculator");  //creating the hexadecimal calculator

            System.out.println("1: Compute a Hexadecimal Calculation");
            System.out.println("2: Convert a Hexadecimal Number to a Decimal Value");
            System.out.println("3: Convert a Decimal Value to a Hexadecimal Number");

            System.out.println("Enter 1,2, or 3:");
            Scanner options = new Scanner(System.in);  //getting the input for what method to call
            int choiceNum = options.nextInt();

            switch(choiceNum){  //calling a certain method based on the input
                case 1: calcHex(); break;
                case 2:
                    System.out.println("Enter Hexadecimal Values to Convert to Decimal Value:");
                    Scanner hexInput = new Scanner(System.in);
                    String hexStr = hexInput.next();

                    int decimalVal = convertHex(hexStr);

                    System.out.println(decimalVal); //output
                    break;
                case 3:
                    System.out.println("Enter a Decimal to Convert to a HexaDecimal Value:");
                    Scanner decInput = new Scanner(System.in);
                    int decimal = decInput.nextInt();

                    if(decimal < 0){
                        System.out.print("-");
                        decimal *= -1;
                    }

                    String hex = convertDecimalH(decimal);

                    System.out.println(hex); //output
                    break;
            }
        }
    }

    /**
     * Calculates a binary expression.
     */
    public static void calcBinary(){  //perform calculations on binary numbers

        System.out.println("Enter First Binary Number:"); //input of the first binary number
        Scanner firstInput = new Scanner(System.in);
        int firstBinary = firstInput.nextInt();

        System.out.println("Enter + - * or /");
        Scanner symbolInput = new Scanner(System.in);
        char symbol = symbolInput.next().charAt(0);

        System.out.println("Enter Second Binary Number:");  //input of the second binary number
        Scanner secondInput = new Scanner(System.in);
        int secondBinary = secondInput.nextInt();

        switch (symbol){
            case '+':  //case addition
                int firstDecimal = convertBinary(firstBinary);  //converting the numbers to decimal
                int secondDecimal = convertBinary(secondBinary);

                int add = firstDecimal + secondDecimal;   //adding the numbers
                int binaryAdd[] = convertDecimalB(add);   //converting back to binary

                int i = binaryAdd[0];

                for (int j = i; j >= 1; j--) {  // printing binary array in reverse order
                    System.out.print(binaryAdd[j]);
                }
                break;

            case '-':
                int decimal1 = convertBinary(firstBinary);  //converting the numbers to decimal
                int decimal2 = convertBinary(secondBinary);

                int minus = decimal1 - decimal2;   //subtracting the numbers
                boolean negative = false;

                if(minus < 0){  //checking to see if it is a negative result
                    minus = minus * -1;
                    negative  = true;
                }

                int binaryMinus[] = convertDecimalB(minus);   //converting back to binary

                int k = binaryMinus[0];

                if(negative){
                    System.out.print("-"); //negative output
                }

                for (int j = k; j >= 1; j--) {  // printing binary array in reverse order
                    System.out.print(binaryMinus[j]);
                }
                break;

            case '*':
                int decimal_1 = convertBinary(firstBinary);  //converting the numbers to decimal
                int decimal_2 = convertBinary(secondBinary);

                int times = decimal_1 * decimal_2;   //multiplying the numbers
                int binaryTimes[] = convertDecimalB(times);   //converting back to binary

                int l = binaryTimes[0];

                for (int j = l; j >= 1; j--) {  // printing binary array in reverse order
                    System.out.print(binaryTimes[j]);
                }
                break;
            case '/':
                int decimalfirst = convertBinary(firstBinary);  //converting the numbers to decimal
                int decimalsecond = convertBinary(secondBinary);

                int divide = decimalfirst / decimalsecond; //division of the numbers
                int remainder = decimalfirst % decimalsecond; //getting the remainder
                int remainderBin[] = convertDecimalB(remainder);
                int binaryDivide[] = convertDecimalB(divide);   //converting back to binary

                int m = binaryDivide[0];

                for (int j = m; j >= 1; j--) {  // printing binary array in reverse order
                    System.out.print(binaryDivide[j]);
                }

                m = remainderBin[0];
                System.out.print(" remainder "); //outputting remainder
                for (int h = m; h >= 1; h--) {  // printing binary array in reverse order
                    System.out.print(remainderBin[h]);
                }
                break;
        }
    }

    /**
     * Calculates a Hexadecimal expression
     */
    public static void calcHex(){

        System.out.println("Enter first Hexadecimal Value:");  //getting input for first value
        Scanner firstInput = new Scanner(System.in);
        String firstHex = firstInput.next();
        boolean negative1 = false;

        if(firstHex.charAt(0) == '-'){
            negative1 = true;
        }

        System.out.println("Enter + - * or /");
        Scanner symbolInput = new Scanner(System.in); //getting symbol input
        char symbol = symbolInput.next().charAt(0);

        System.out.println("Enter Second Hexadecimal Value:");  //getting input for second value
        Scanner secondInput = new Scanner(System.in);
        String secondHex = secondInput.next();
        boolean negative2 = false;

        if(secondHex.charAt(0) == '-'){
            negative2 = true;
        }

        switch(symbol) {
            case '+':   //case addition
                int firstIntHex = convertHex(firstHex);
                int secondIntHex = convertHex(secondHex); //converting to decimal

                if (negative1) {
                    firstIntHex = firstIntHex * -1;  //making it negative if it is
                } else if (negative2) {
                    secondIntHex = secondIntHex * -1;
                }

                int add = firstIntHex + secondIntHex;  //doing addition
                boolean negativeAdd = false;
                if (add < 0) {   //checking if addition is false
                    negativeAdd = true;
                }

                String addHex = convertDecimalH(add);  //converting back to hex

                if (negativeAdd) {  //output
                    System.out.println("-" + addHex);
                } else {
                    System.out.println(addHex);
                }
                break;

            case '-':   // case subtraction
                firstIntHex = convertHex(firstHex);
                secondIntHex = convertHex(secondHex); //converting to decimal

                if (negative1) {
                    firstIntHex = firstIntHex * -1;  //making it negative if it is
                } else if (negative2) {
                    secondIntHex = secondIntHex * -1;
                }

                int minus = firstIntHex - secondIntHex;//doing subtraction
                boolean negative = false;  //checking if negative
                if (minus < 0) {
                    negative = true;
                    minus = minus * -1;
                }

                String minusHex = convertDecimalH(minus);  //converting back to hex

                if (negative) {  //output
                    System.out.println("-" + minusHex);
                } else {
                    System.out.println(minusHex);
                }
                break;

            case '*':   //case multiplication
                firstIntHex = convertHex(firstHex);
                secondIntHex = convertHex(secondHex); //converting to decimal

                if (negative1) {
                    firstIntHex = firstIntHex * -1;  //making it negative if it is
                } else if (negative2) {
                    secondIntHex = secondIntHex * -1;
                }

                int times = firstIntHex * secondIntHex;  //doing multiplication
                negative = false;
                if (times < 0) {
                    negative = true;
                    times = times * -1;
                }

                String timesHex = convertDecimalH(times);  //converting back to hex

                if (negative) { //output
                    System.out.println("-" + timesHex);
                } else {
                    System.out.println(timesHex);
                }
                break;
            case '/':   //case division
                firstIntHex = convertHex(firstHex);
                secondIntHex = convertHex(secondHex); //converting to decimal

                if (negative1) {
                    firstIntHex = firstIntHex * -1;  //making it negative if it is
                } else if (negative2) {
                    secondIntHex = secondIntHex * -1;
                }

                int divide = firstIntHex / secondIntHex;  //doing division
                int remainder = firstIntHex % secondIntHex;  //getting the remainder

                negative = false;
                if(divide < 0){
                    negative = true;
                    divide = divide * -1;
                }

                String divideHex = convertDecimalH(divide);  //converting back to hex
                String remainderHex = convertDecimalH(remainder);

                if(negative){ //output
                    System.out.println("-" + divideHex + " remainder " + remainderHex);
                }else {
                    System.out.println(divideHex + " remainder " + remainderHex);
                }
                break;
        }
    }

    /**
     * Converts a binary number to a decimal number
     * @param binary the binary value to convert to a decimal
     * @return the decimal value
     */
    public static int convertBinary(int binary){ //convert Binary to decimal

        String binaryNumber = binary + "";

        int length = binaryNumber.length();
        int decimalValue = 0;
        int base = 1;  //i.e. 2^0 is 1

        for (int i =length; i>0; i--){
            if(binaryNumber.charAt(i-1)== '1'){
                decimalValue += base;
                base = base *2;
            }else{
                base = base *2;
            }
        }

        return decimalValue;

    }

    /**
     * Converts a Hexadecimal Value to a decimal value
     * @param s a hexadecimal value
     * @return a decimal value
     */
    public static int convertHex(String s){  //convert Hex to decimal
        String digits = "0123456789ABCDEF";    //all the digits of a hexadecimal
        s = s.toUpperCase();
        int val = 0;
        boolean negative = false;

        if(s.charAt(0) == '-'){  //if negative
            negative = true;
        }
        if(negative){
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                int d = digits.indexOf(c);    //searching for the index in the string of digits
                val = 16 * val + d;
            }
        }else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int d = digits.indexOf(c);    //searching for the index in the string of digits
                val = 16 * val + d;
            }
        }
        return val;

    }

    /**
     * Converts a decimal number to a binary number
     * @param decNum the decimal number to convert
     * @return the binary number
     */
    public static int[] convertDecimalB(int decNum){  //convert Decimal to Binary

        int[] binaryNum = new int[1000];  // array to store binary number

        int i = 1;   // counter for binary array
        while (decNum > 0) {
            binaryNum[i] = decNum % 2; // storing remainder in binary array
            decNum = decNum / 2;
            i++;
        }
        binaryNum[0] = i-1;

        return binaryNum;

    }

    /**
     * converts a decimal to a hexadecimal value
     * @param num the decimal value to be converted
     * @return the hexadecimal value
     */
    public static String convertDecimalH(int num){   //convert Decimal to Hex

        int rem; // For storing remainder
        String str2=""; // For storing result

        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; // Digits in hexadecimal number system

        if(num == 0){
            return "0";
        }else if(num < 0){
            num = num * -1;
        }

        while(num>0) {
            rem=num%16;
            str2=hex[rem]+str2;
            num=num/16;
        }

        return str2;
    }
}