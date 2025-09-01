import java.util.Arrays;

public class task5 {
    public static void main(String[] args) {
        char[] nuts = {'@', '%', '$', '#', '^'};
        char[] bolts = {'%', '@', '#', '$', '^'};

        NutsAndBolts(nuts, bolts);

        System.out.println("Matching the Nuts and Bolts:");
        System.out.println("nuts: " + Arrays.toString(nuts));
        System.out.println("bolts: " + Arrays.toString(bolts));
    }

    private static final char[] order = {'!', '#', '$', '%', '&', '*', '@', '^', '~'};



    private static int[] BuildIndexMap(char[] a) {
        int[] indexMap = new int[256];

        for (int i = 0; i < a.length; i++) {
            indexMap[a[i]] = i;
        }

        return indexMap;
    }
    private static int partitioning(char[] arr, int l, int h, char pivot, int[] indexMap) {
        int i = l - 1;

        for (int j = l; j < h; j++) {
            if (compare(arr[j], pivot) < 0) {
                i++;
                swapping(arr, i, j);
            } else if (compare(arr[j], pivot) == 0) {
                swapping(arr, j, h);
                j--;
            }
        }

        i++;
        swapping(arr, i, h);

        if (indexMap != null) {
            int pivotIndex = indexMap[pivot];
            swapping(indexMap, i, pivotIndex);
        }

        return i;
    }
    public static void quicksort(char[] nuts, char[] bolts, int l, int h, int[] nutIndexMap) {
        if (l < h) {
            int pivotIndex = partitioning(bolts, l, h, nuts[h], nutIndexMap);
            partitioning(nuts, l, h, bolts[pivotIndex], null);

            quicksort(nuts, bolts, l, pivotIndex - 1, nutIndexMap);
            quicksort(nuts, bolts, pivotIndex + 1, h, nutIndexMap);
        }
    }


    public static void NutsAndBolts(char[] n, char[] b) {
        if (n == null || b == null || n.length != b.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] nutIndexMap = BuildIndexMap(n);
        quicksort(n, b, 0, n.length - 1, nutIndexMap);
    }
    private static int indexof(char m) {
        for (int i = 0; i < order.length; i++) {
            if (order[i] == m) {
                return i;
            }
        }
        return -1;
    }
    private static void swapping(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int compare(char a, char b) {
        return indexof(a) - indexof(b);
    }
    private static void swapping(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }






}
