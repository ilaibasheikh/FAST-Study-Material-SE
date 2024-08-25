import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4, 5};
        boolean isSorted = isSortedArray(arr, arr.length);

        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]);
        }

        if (isSorted) {

            System.out.println("The array is sorted.");
        } else {
            System.out.println("The array is not sorted.");
        }
    }

    public static boolean isSortedArray(int[] arr, int n) {

        if (n <= 1) {
            return true;
        }

        if (arr[n - 1] < arr[n - 2]) {
            return false;
        }
        return isSortedArray(arr, n - 1);
    }
}

