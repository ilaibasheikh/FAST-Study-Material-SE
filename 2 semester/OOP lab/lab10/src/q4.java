import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        try {
            System.out.print("Enter a sentence: ");
            String sentence = a.nextLine();


            if (sentence == null || sentence.isEmpty()) {
                throw new Exception("Error: Input string is null or empty!");
            }


            String[] words = sentence.split(" ");

            if (words.length < 2) {
                throw new Exception("Error: Input string contains less than two words!");
            }

            String uppersentence = sentence.toUpperCase();
            String lowersentence = sentence.toLowerCase();
            System.out.println("Modified sentence: " + uppersentence);
            System.out.println("Modified sentence: " + lowersentence);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}