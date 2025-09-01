import java.util.Arrays;

public class task2 {

    public static int getMax(int a[], int n)
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
    public static void AscRadix(int a[], int n) {
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

    public static void DescRadix(int a[], int n) {
        int m = getMax(a,n);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            DescCount(a, exp);
        }
    }


    public static void main(String[] args) {
        int a[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = a.length;

        System.out.println(" Array:");
        System.out.println(Arrays.toString(a));

        AscRadix(a,n);
        System.out.println(" Ascending Order:");
        System.out.println(Arrays.toString(a));

        DescRadix(a,n);
        System.out.println(" Descending Order:");
        System.out.println(Arrays.toString(a));
    }
}
