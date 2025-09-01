public class PrimitiveDataTypeExample {
    public static void main(String[] args) {
        // byte
        byte byteValue = 10;
        
        // short
        short shortValue = 20;
        
        // int
        int intValue = 30;
        
        // long
        long longValue = 40L;  // Note the 'L' suffix to specify a long literal
        
        // float
        float floatValue = 50.5f;  // Note the 'f' suffix to specify a float literal
        
        // double
        double doubleValue = 60.6;
        
        // char
        char charValue = 'A';
        
        // boolean
        boolean booleanValue = true;
        
        // Using Math library for some operations
        double sum = byteValue + shortValue + intValue + longValue + floatValue + doubleValue;
        double sqrtResult = Math.sqrt(intValue);
        double powerResult = Math.pow(doubleValue, 2);
        
        // Printing the results
        System.out.println("Sum: " + sum);
        System.out.println("Square root of intValue: " + sqrtResult);
        System.out.println("doubleValue squared: " + powerResult);
        
        // char to int conversion
        int charToInt = (int) charValue;  // Casting char to int
        System.out.println("char to int: " + charToInt);
        
        // boolean to String conversion
        String booleanToString = Boolean.toString(booleanValue);
        System.out.println("boolean to String: " + booleanToString);
        
        // Casting double to int (truncate decimal part)
        int doubleToInt = (int) doubleValue;
        System.out.println("double to int: " + doubleToInt);
        
        // Casting float to int (truncate decimal part)
        int floatToInt = (int) floatValue;
        System.out.println("float to int: " + floatToInt);
        
        // Casting int to short (may result in data loss if out of range)
        short intToShort = (short) intValue;
        System.out.println("int to short: " + intToShort);
        
        double originalValueNew = 9.0000005678667777777566565634563634646343432995577;

     // Cast to int (truncate decimal part)
     int intValueNew = (int) originalValueNew;

     // Cast int to float
     float floatValueNew = (float) intValueNew;

     System.out.println("Original Value: " + originalValueNew);
     System.out.println("Int Value: " + intValueNew);
     System.out.println("Float Value: " + floatValueNew);
        
        
        
    }
}
