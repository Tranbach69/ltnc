
import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ChangeBaseNumber {
    Scanner sc = new Scanner(System.in);
    
    public void MenuCovertFrom(){
        System.out.println("-------------MENU---------------");
        System.out.println("1. Convert From Binary \n"
                + "2. Convert From Decimal \n"
                + "3. Convert From Hexadecimal"
                );
    }
    
    public void MenuConnvertTo(){
        System.out.println("");
        System.out.println("1. Convert To Binnary \n"
                + "2. Convert To Decimal \n"
                + "3. Convert To Hexadecimal");
    }
    
    
    //Seclect an option
    public int SelectOption() {
        int max = 3;
        int min = 1;
        System.out.print("Enter your choice: ");
        //loop unitl user input correct
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                // if input choice value out a range [max,min]
                if (choice < min || choice > max) {
                    throw new Exception();
                }
                return choice;
            } catch (Exception e) {
                System.err.println("Invalid choice. Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    //user choose the base number input
    public int ChooseBaseNumberInput(){
        MenuCovertFrom();
        int choiceConvertFrom = SelectOption();
        return choiceConvertFrom;
    }
    
    // user choose the base Number out 
    public int ChooseBaseNumberOut(){
        MenuConnvertTo();
        int choiceConvertTo = SelectOption();
        System.out.println("--------------------------------");        
        return choiceConvertTo;
    }
    
    // input value
    public String InputValue(int BaseNumberInput){
        if(BaseNumberInput == 1){
            return InputBinary();
        }else if(BaseNumberInput == 2){
            return InputDecimal();
        }else{
            return InputHexaDecimal();
        }
    }
    
    Pattern PaternBinary = Pattern.compile("^[0-1]+$");
    Pattern PaternDecimal = Pattern.compile("^[0-9]+$");
    Pattern PaternHexadecimal = Pattern.compile("^[0-9A-F]+$");
    
    // input number binary
    public String InputBinary() {
        System.out.print("Enter number binary: ");
        //loop until user input correct
        while (true) {
            String binary = sc.nextLine().trim();
            
            if (PaternBinary.matcher(binary).find()) {
                return binary;
            }
            System.err.println("Must be enter 0 or 1");
            System.out.print("Enter again: ");
        }
    }
    
    //input number binary
    public String InputDecimal() {
        System.out.print("Enter number decimal: ");
        //loop until user input correct
        while (true) {
            String decimal = sc.nextLine().trim();
            if (PaternDecimal.matcher(decimal).find()) {
                return decimal;
            }
            System.err.println("Must be enter 0-9");
            System.out.print("Enter again: ");
        }
    }

    // input number binary
    public String InputHexaDecimal() {
        System.out.print("Enter number hexadecimal: ");
        //loop until user input correct
        while (true) {
            String hexadecimal = sc.nextLine().trim();
            if (PaternHexadecimal.matcher(hexadecimal).find()) {
                return hexadecimal;
            }
            System.err.println("Must be enter 0-9 A-F");
            System.out.print("Enter again: ");
        }
    }
    
    // Convert Base Number
    public String ConvertBaseNumber(String value, int BaseNumberFrom, int BaseNumberTo){
        if(BaseNumberFrom == 1 && BaseNumberTo == 2){
            return ConvertBaseBinaryToDecimal(value);
            //System.out.println( ConvertBaseBinaryToDecimal(value));
        }else if(BaseNumberFrom == 2 && BaseNumberTo == 3){
            return ConvertBaseDecimalToHexaDecimal(value);
            //System.out.println(ConvertBaseDecimalToHexaDecimal(value));
        }else if(BaseNumberFrom == 1 && BaseNumberTo == 3){
            return ConvertBaseBinaryToHexadecimal(value);
            //System.out.println(ConvertBaseBinaryToHexadecimal(value));
        }else if(BaseNumberFrom == 2 && BaseNumberTo == 1){
            return ConvertBaseDecimalToBinary(value);
            //System.out.println(ConvertBaseDecimalToBinary(value));
        }else if(BaseNumberFrom == 3 && BaseNumberTo == 2){
            return ConvertBaseHexaDecimalToDeciamal(value);
            //System.out.println(ConvertBaseHexaDecimalToDeciamal(value));
        }else{
            return ConvertBaseHexadecimalToBinary(value);
            //System.out.println(ConvertBaseHexadecimalToBinary(value));
        }
    }
    
    //Display
    public void DisplayValue(String valueOutput, int BaseNumberTo){
        System.out.print("Value after convert: ");
        if(BaseNumberTo == 1){
            System.out.println(valueOutput + "(BIN)");
        }else if(BaseNumberTo == 2){
            System.out.println(valueOutput + "(DEC)");
        }else{
            System.out.println(valueOutput + "(HEX)");
        }
    }
    
    // convert base binary to decimal
    public String ConvertBaseBinaryToDecimal(String value){
        BigInteger decimal = new BigInteger("0");
        BigInteger base = new BigInteger("2");
        String[] array =  value.split("");
        int index = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            BigInteger valueOfIndex =  new BigInteger(array[i]);
            decimal = decimal.add(valueOfIndex.multiply(base.pow(index)));
            index--;
        }
        return String.valueOf(decimal);
    }
    
    // convert base decimal to hexadecimal
    public String ConvertBaseDecimalToHexaDecimal(String value){
        BigInteger base = new BigInteger("16");
        BigInteger remainder = new BigInteger("0");
        BigInteger decimal = new BigInteger(value);
        String hexadecimal = "" ;
        String[] hexaDigits = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        while(decimal.longValue() != 0){
            remainder = decimal.mod(base);
            hexadecimal += hexaDigits[remainder.intValue()];
            decimal = decimal.divide(base);
        }
        String reverseHexa = "";
        for (int i = hexadecimal.length()-1 ; i >= 0; i--) {
            reverseHexa += String.valueOf(hexadecimal.charAt(i));
        }
        return reverseHexa;
    }
    
    // convert base binary to haxadecimal
    public String ConvertBaseBinaryToHexadecimal(String value){
        String decimal = ConvertBaseBinaryToDecimal(value);
        String Hexadecimal = ConvertBaseDecimalToHexaDecimal(decimal);
        return Hexadecimal;
    }
    
    // convert base decimal to binary
    public String ConvertBaseDecimalToBinary(String value){
        BigInteger base = new BigInteger("2");
        BigInteger remainder = new BigInteger("0");
        BigInteger decimal = new BigInteger(value);
        String binary = "" ;
        while(decimal.longValue() != 0){
            remainder = decimal.mod(base);
            binary += String.valueOf(remainder);
            decimal = decimal.divide(base);
        }
        String reverseBinary = "";
        for (int i = binary.length()-1 ; i >= 0; i--) {
            reverseBinary += String.valueOf(binary.charAt(i));
        }
        return reverseBinary;
    }
    
    // hexadigist
    public String ConvertString(String string){
        if(string.equals("A")){
            return "10";
        }else if(string.equals("B")){
            return "11";
        }else if(string.equals("C")){
            return "12";
        }else if(string.equals("D")){
            return "13";
        }else if(string.equals("E")){
            return "14";
        }else if(string.equals("F")){
            return "15";
        }
        return null;  
    }
    
    // convert base hexadecimal to decimal
    public String ConvertBaseHexaDecimalToDeciamal(String value){
        BigInteger decimal = new BigInteger("0");
        BigInteger base = new BigInteger("16");
        String[] array =  value.split("");
        int index = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if(ConvertString(array[i]) != null){
                array[i] = ConvertString(array[i]);
            }
            BigInteger valueOfIndex =  new BigInteger(array[i]);
            decimal = decimal.add(valueOfIndex.multiply(base.pow(index)));
            index--;
        }
        return String.valueOf(decimal);
    }
    
    // convert base hexadecimal to binary
    public String ConvertBaseHexadecimalToBinary(String value){
        String decimal = ConvertBaseHexaDecimalToDeciamal(value);
        String binary = ConvertBaseDecimalToBinary(decimal);
        return binary;
    }
    
    
}
