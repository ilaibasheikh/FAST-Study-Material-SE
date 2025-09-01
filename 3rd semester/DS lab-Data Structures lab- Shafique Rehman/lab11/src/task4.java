public class task4 {
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        int result = Triplets(arr);
        System.out.println("array = {0, -1, 2, -3, 1}");
        System.out.println("Answer " + result);
    }
    private static boolean doescontain(int[] a, int target, int start) {
        for (int i = start; i < a.length; i++) {
            if (a[i] == target) {
                return true;
            }
        }
        return false;
    }
    public static int Triplets(int[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = -(a[i] + a[j]);
                if (doescontain(a, x, j + 1)) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
