import java.util.Arrays;

public class q1 {
    public static void main(String[] args) {
        int[] inputArray = {7, 1, 6, 2, 5, 9, 10, 2};


        int[] maxHeap = MaxHeap(inputArray.clone());
        System.out.println("Max " + Arrays.toString(maxHeap));
        int[] minHeap = MinHeap(inputArray.clone());
        System.out.println("Min " + Arrays.toString(minHeap));



    }

    public static int[] MinHeap(int[] arr) {
        int n = arr.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyMin(arr, n, i);
        }

        return arr;
    }

    public static void heapifyMax(int[] arr, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapifyMax(arr, n, largest);
        }
    }
    private static void heapifyMin(int[] a, int n, int i) {
        int smallest = i;
        int left= 2 * i + 1;
        int rightC = 2 * i + 2;

        if (left < n && a[left] < a[smallest]) {
            smallest = left;
        }

        if (rightC < n && a[rightC] < a[smallest]) {
            smallest = rightC;
        }

        if (smallest != i) {
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;

            heapifyMin(a, n, smallest);
        }
    }
    public static int[] MaxHeap(int[] arr) {
        int n = arr.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyMax(arr, n, i);
        }

        return arr;
    }




}
