import java.util.Arrays;

public class task1 {

    public static int getMax(int a[], int n){
        int max = a[0];

        for( int i = 1; i<n; i++){

            if (a[i] > max){
                max= a[i];
            }
        }
        return max;
    }

    public static void count(int a[], int n, int exp){
        int [ ] output = new int[n];
        int count [] = new int[10];
        Arrays.fill(count,0);
        for (int i = 0; i< n ; i++){
            count[(a[i]/exp) %10]++;
        }
        for(int i = 1; i< 10 ; i++){
            count[i] = count[i]+ count[i-1];
        }
        for(int i = n-1;i>=0 ;i--){
         output[  count[(a[i]/exp) %10]- 1] = a[i];
            count[(a[i]/exp) %10]--;
        }

        for(int i = 0; i<n ; i++){
            a[i] = output[i];
        }

    }

    public static void radix(int a[], int n){
        int max = getMax(a,n);

        for( int exp = 1; max/exp >0; exp= exp*10){
            count(a,n,exp);
        }
    }

    public static void display(int [] a, int n){
        for(int i =0; i<n ; i++){
            System.out.print( a[i] + " ");
        }
    }
    public static void main(String[] args) {
    int a [] = {170,45, 75, 90, 802, 24, 2,66};
    int n = a.length;
    radix(a,n);
    display(a,n);
    }
}