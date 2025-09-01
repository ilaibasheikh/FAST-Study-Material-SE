import java.util.Scanner;

public class task5 {

    public static  int interpolation(int[] a,int hi, int lo, int x){
        int pos;
        if (lo<=hi && x>= a[lo] && x<=a[hi] ){

            pos = lo + (((x - a[lo] )* (hi - lo))/ (a[hi] - a[lo]));

            if(a[pos] == x){
                return  pos;
            }

            if(a[pos] >x){
                return interpolation(a,hi, pos-1, x);
            }if(a[pos] <x){
                return interpolation(a,pos+1, lo, x);
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int n =arr.length;
        Scanner a = new Scanner(System.in);
        System.out.println("Enter item to be searched:");
        int x = a.nextInt();
        int index = interpolation(arr,n-1,0, x);

        if(index != -1){
            System.out.println("Element found at index " + index);
        }
        else {
            System.out.println("Element not found");
        }






    }
}
