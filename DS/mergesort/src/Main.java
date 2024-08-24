// Java program for Merge Sort

class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int a[], int lb, int mid, int ub)
    {
        // Find sizes of two subarrays to be merged
//        int n1 = m - l + 1;
//        int n2 = r - m;
//
//        // Create temp arrays
//        int L[] = new int[n1];
//        int R[] = new int[n2];
//
//        // Copy data to temp arrays
//        for (int i = 0; i < n1; ++i)
//            L[i] = arr[l + i];
//        for (int j = 0; j < n2; ++j)
//            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = lb, j = mid +1;
        int n = a.length;
        int b[] = new int [n];

        // Initial index of merged subarray array
        int k = lb;
        while (i <=mid  && j <= ub) {

            if (a[i] <= a[j]) {
                b[k] = a[i];
                i++;
            }
            else {
                b[k] = a[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        if (i >mid) {
            while (j <= ub) {
                b[k] = a[j];
                j++;
                k++;
            }
        }
        else{
            while (i <= mid) {
                b[k] = a[i];
                i++;
                k++;
            }
        }

        for (k = lb; k <= ub ; k++) {
            a[k]= b[k];
        }

        // Copy remaining elements of R[] if any

    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(int a[], int lb, int ub)
    {
        if (lb < ub) {

            // Find the middle point
            int mid = (lb + ub) / 2;

            // Sort first and second halves
            sort(a, lb, mid);
            sort(a, mid + 1, ub);

            // Merge the sorted halves
            merge(a, lb, mid, ub);
        }
    }

    // A utility function to print array of size n
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given array is");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }
}
/* This code is contributed by Rajat Mishra */
