//public class task1 {
//    public static int[] growSize(int [] array)
//    {
//        int sizeofarray = array.length;
//
//        int temp[] = null;
//
//        temp = new int[array.length * 2];
//        {
//            for (int i = 0; i < array.length; i++)
//            {
//
//                temp[i] = array[i];
//            }
//        }
//
//        array = temp;
//        sizeofarray= array.length * 2;
//
//        return array;
//    }
//
//    public static void printArray(int[] array){
//        int n=array.length;
//        for( int i= 0; i<n; i++){
//            System.out.print(array[i] + " ");
//        }
//    }
//
//
//    public static void main(String[] args) {
//        int [] array = {3,1,2,5,8};
//        printArray(array);
//
//        array = growSize(array);
//
//        array[4+1] = 9;
//        array[4+2] = 11;
//        array[4+3] = 4;
//
//        System.out.println();
//        printArray(array);
//
//        int size= array.length;
//        for(int  i= 0; i< size; i++){
//            if (array[i] == 1 || array[i] == 2 || array[i] == 5 )
//            {
//                for (int j = i; j <size -1; j++) {
//                    array[j ] = array[j+1];
//                }
//                size--;
//                i--;
//            }
//
//
//        }
//        System.out.println();
//        printArray(array);
//    }
//}