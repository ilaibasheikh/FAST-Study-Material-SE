import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        String grade;
        int assignment;
        System.out.println("Enter your grade");
        grade = A.next();
        System.out.println("Enter the no of assignments you failed in");
        assignment = A.nextInt();
        switch(grade){
            case "A" :
                if (assignment >3){
                    System.out.println("No grace marks");
                }
                else if (assignment<= 3) {
                    System.out.println("Grace marks = 5");
                }
                break;
            case "B" :
                if (assignment >2){
                    System.out.println("No grace marks");
                }
                else if (assignment<= 2) {
                    System.out.println("Grace marks = 4");
                }
                break;
            case "C":
                if (assignment >1){
                    System.out.println("No grace marks");
                }
                else if (assignment<= 1) {
                    System.out.println("Grace marks = 5");
                }
                break;
            default:
                System.out.println("Enter valid grade");

        }

    }
}
