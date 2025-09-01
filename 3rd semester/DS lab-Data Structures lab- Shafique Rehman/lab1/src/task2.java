import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        int array[] = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        System.out.println("This is the original array:");
        System.out.println(array.length);
        for (int i =0;i<array.length; i++){
            System.out.print( array[i] + " ");

        }
        System.out.println();
        System.out.println("Enter the number of steps to rotate ");
        Scanner a = new Scanner(System.in);
        int x;
        x= a.nextInt();

        System.out.println("This is the rotated array:");
        int end;
        for (int i =0;i< x; i++){
            end =array[array.length-1];

            for(int j = array.length-1; j > 0; j--){
                array[j] = array[j-1];
            }

            array[0] = end;
        }
        System.out.println("This is the rotated array:");

        for(int i = 0; i< array.length; i++){
            System.out.print(array[i] + " ");
        }

    }
}
