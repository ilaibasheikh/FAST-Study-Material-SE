import java.util.Scanner;

class Sorting {
    // we can also use Arrays.sort(array) method to avoid the long working
    public void sort(int[] a, int n) {
        int i = 0, j = 0, temp = 0;
        for (i = 0; i<n; i++) {
            for (j = i+ 1; j<n; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("In ascending order:");
        for (i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }

    public void sort(String[] a, int n) {
        int i = 0, j = 0;
        String temp;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if ((a[i].compareToIgnoreCase(a[j])) < 0) { // It compares the unicode value, ignoring upper case, it converts to lower case
                    temp = a[i];                                //if equal returns 0, first string less returns <0,  first string greater returns >0
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println("In ascending order:");
        for (i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }

    public void sort(int[] a, boolean descending, int n) {
        int i = 0, j = 0, temp = 0;
        if (descending == Boolean.TRUE) {
            for (i = 0; i < n; i++) {
                for (j = i + 1; j < n; j++) {
                    if (a[i] < a[j]) {
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
            System.out.println("In descending order:");
            for (i = 0; i < n; i++) {
                System.out.println(a[i]);
            }
        }
        if (descending == Boolean.FALSE) {
            for (i = 0; i < n; i++) {
                for (j = i + 1; j < n; j++) {
                    if (a[i] > a[j]) {
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
            System.out.println("In ascending order:");
            for (i = 0; i < n; i++) {
                System.out.println(a[i]);
            }
        }
    }

    public void sort(String[] a, boolean descending, int n){
        int i = 0, j = 0;
        String temp;
        if(descending==Boolean.FALSE){
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if ((a[i].compareToIgnoreCase(a[j])) < 0) {
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }

            System.out.println("In ascending order:");
            for (i = 0; i < n; i++) {
                System.out.println(a[i]);
            }
        }

        if(descending==Boolean.TRUE){
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if ((a[i].compareToIgnoreCase(a[j])) > 0) {
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }

            System.out.println("In descending order:");
            for (i = 0; i < n; i++) {
                System.out.println(a[i]);
            }
        }
    }
}
public class q5 {
    public static void main(String[] args) {
        Scanner A =new Scanner(System.in);
        Sorting s = new Sorting();
        System.out.println("Enter array size:");
        int n= A.nextInt();
        int arr1[] = new int[n];

        int i=0, j=0;
        System.out.println("Enter Integer array elements:");
        for(i=0; i<n; i++){
            arr1[i]= A.nextInt();
        }
        String arr2[] = new String[n];
        System.out.println("Enter String array elements:");
        for(i=0; i<n; i++){
            arr2[i]= A.next();
        }
        boolean d1, d2;
        System.out.println("Enter boolean value for integer array:");
        d1= A.nextBoolean();

        System.out.println("Enter boolean value for String array:");
        d2= A.nextBoolean();

        s.sort(arr1, n);
        s.sort(arr2, n);
        s.sort(arr1, d1, n);
        s.sort(arr2, d2, n);
    }
}