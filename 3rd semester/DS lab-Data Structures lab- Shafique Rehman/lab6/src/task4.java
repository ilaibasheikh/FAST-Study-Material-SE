import java.util.Arrays;

public class task4 {

    public static int[] addSort(int[] a, int key) {
        int[] newArray = Arrays.copyOf(a, a.length + 1);
        newArray[newArray.length - 1] = key;
        Arrays.sort(newArray);
        return newArray;
    }

    public static int Binarysearch(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 12, 14, 23, 34, 55, 65, 75, 78};
        int rollNum = 5195;
        int lastDigits = rollNum % 100;

        Arrays.sort(a);
        System.out.println(" Array : " + Arrays.toString(a));

        int index = Binarysearch(a, lastDigits);

        if (index == -1) {
            a = addSort(a, lastDigits);
            System.out.println("Your value is not found, sorted array: " + Arrays.toString(a));
            index = Binarysearch(a, lastDigits);
        }

        if (index != -1) {
            int answer = a[index];
            System.out.println("The value matching to the last two digits (95): " + answer);
        } else {
            System.out.println("The value matching to the last two digits not found.");
        }
    }
}
