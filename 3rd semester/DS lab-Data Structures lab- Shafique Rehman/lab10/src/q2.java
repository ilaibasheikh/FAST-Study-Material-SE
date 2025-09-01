import java.util.Arrays;

public class q2 {
    public static void main(String[] args) {
        int[] inputArray = {35, 33, 42, 10, 14, 19, 27, 44, 26, 31};


        Min(inputArray);
        System.out.println("Min  " + Arrays.toString(inputArray));

        int rootValue = deleteRoot(inputArray);
        System.out.println("Root Deleted: " + rootValue);

        Max(inputArray);
        System.out.println("Max  " + Arrays.toString(inputArray));

        System.out.println("Sorted " + Arrays.toString(inputArray));
    }

    public static void Max(int[] a) {
        int n = a.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyMax(a, n, i);
        }
    }
    public static void Min(int[] a) {
        int n = a.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyMin(a, n, i);
        }
    }

    public static void heapifyMin(int[] a, int n, int i) {
        int small = i;
        int leftC = 2 * i + 1;
        int rightC = 2 * i + 2;

        if (leftC < n && a[leftC] < a[small]) {
            small = leftC;
        }

        if (rightC < n && a[rightC] < a[small]) {
            small = rightC;
        }

        if (small != i) {
            int temp = a[i];
            a[i] = a[small];
            a[small] = temp;

            heapifyMin(a, n, small);
        }
    }

    public static int deleteRoot(int[] a) {
        int n = a.length;

        if (n == 0) {
            throw new IllegalStateException("Cannot delete from an empty heap");
        }

        int rootValue = a[0];
        a[0] = a[n - 1];
        a = Arrays.copyOf(a, n - 1);

        heapifyMin(a, n - 1, 0);

        return rootValue;
    }



    private static void heapifyMax(int[] a, int n, int i) {
        int large = i;
        int leftC = 2 * i + 1;
        int rightC = 2 * i + 2;

        if (leftC < n && a[leftC] > a[large]) {
            large = leftC;
        }

        if (rightC < n && a[rightC] > a[large]) {
            large = rightC;
        }

        if (large != i) {
            int temp = a[i];
            a[i] = a[large];
            a[large] = temp;

            heapifyMax(a, n, large);
        }
    }


}
