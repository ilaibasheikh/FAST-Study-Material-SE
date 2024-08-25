public class task2 {
    public static void main(String[] args) {
        int[] arr = {20,12,15,2,10,1,13,9,5};

        System.out.println("Before: ");
        for (int i = 0; i< arr.length ;i++){
            System.out.print(arr[i] + " ");
        }

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println();

        System.out.println("Sorted:");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();

        System.out.println("Maximum in the middle:");
        int mid= arr[arr.length-1];
        for(int i= arr.length-2 ;i> (arr.length)/2;i--){
            int num = arr[i];
            arr[i+1] = num;

        }
        arr[ (arr.length)/2] = mid;

        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();

    }


}
