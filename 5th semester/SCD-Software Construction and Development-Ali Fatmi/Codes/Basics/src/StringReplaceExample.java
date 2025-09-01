public class StringReplaceExample {
    public static void main(String[] args) {
        // Original string
        String originalString = "I like SCD course";
        
        // Replacing "SCD" with "Software Construction and Design"
        String replacedString = originalString.replace("SCD", "Software Construction and Design");
        
        // Print the updated string
        System.out.println("Original String: " + originalString);
        System.out.println("Replaced String: " + replacedString);
    }
}