import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        System.out.println("How many integers do you wish to add?");
        int n = A.nextInt();
        int i, even= 0 , odd = 0;
        if ( n >0 && n<101){
            for (i=0; i<n ; i++){
                if (i%2 == 0){
                    even = even + i;
                }
                else{
                    odd = odd + i;
                }
            }
        }
        System.out.println("The sum of even integers is " +even);
        System.out.println("The sum of odd integers is "+odd);

    }
}
