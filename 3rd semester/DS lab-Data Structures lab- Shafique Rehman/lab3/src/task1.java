import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int arr[] = new int[10];
        System.out.println("Enter 10 elements");
        for (int i = 0; i<10 ;i++){
            arr[i] = a.nextInt();
        }

        System.out.println("Your array: ");
        for (int i = 0; i< arr.length ;i++){
            System.out.print(arr[i] + " ");
        }

        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        System.out.println();
        System.out.println("The four minimum values are:");
        for(int i = 0; i<4;i++){
            System.out.print(arr[i] + " ");
        }


    }
}
