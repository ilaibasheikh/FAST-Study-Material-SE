import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner a =new Scanner(System.in);
        int factorial=1;
        int i=0;
        System.out.println("Enter Integer to get a factorial Of ");
        String Num;
        int num1;
        Num=a.next();
        try{
            num1=Integer.parseInt(Num);
            if(num1<0){
                throw new IllegalArgumentException("The Input Number must not be negative number");
            }
            for(i=1;i<=num1;i++){
                factorial*=i;
            }
            System.out.println("The Factorial of "+num1+" is "+factorial);
        }
        catch (NullPointerException e){
            System.out.println("Input is null");
        }
        catch (NumberFormatException e){
            System.out.println("Invalid Number Format!");
        }

    }
}