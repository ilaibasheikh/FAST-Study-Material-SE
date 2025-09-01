import java.util.Arrays;

public class task3 {

   public  static int getMax(int a[], int n)
    {
        int max = a[0];
        for (int i = 1; i < n; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }
    public static void AscCount(int a[], int exp) {
        int n = a.length;
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(a[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(a[i] / exp) % 10] - 1] = a[i];
            count[(a[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            a[i] = output[i];
        }
    }

    public static void AscRadix(int a[]) {
        int n = a.length;
        int m = getMax(a,n);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            AscCount(a, exp);
        }
    }

    public static void DescCount(int a[], int exp) {
        int n = a.length;
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[9 - (a[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[9 - (a[i] / exp) % 10] - 1] = a[i];
            count[9 - (a[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            a[i] = output[i];
        }
    }
    public static void DescRadix(int a[]) {
        int n = a.length;
        int m = getMax(a,n);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            DescCount(a, exp);
        }
    }
    public static void radix(int a[]) {
        int n = a.length;
        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        int[] oddNum = new int[odd];
        int[] evenNum = new int[even];

        odd = 0;
        even = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                evenNum[even++] = a[i];
            } else {
                oddNum[odd++] = a[i];
            }
        }
        DescRadix(oddNum);
        AscRadix(evenNum);

        int i = 0;
        int j = 0;
        int k = 0;

        while (j < odd) {
            a[i++] = oddNum[j++];
        }

        while (k < even) {
            a[i++] = evenNum[k++];
        }
    }






    public static void main(String[] args) {
        int a[] = { 10, 1, 5, 6, 12, 2, 5, 3, 13, 17, 14 };

        System.out.println("Before  " + Arrays.toString(a));
        radix(a);
        System.out.println("After  " + Arrays.toString(a));
    }

} 