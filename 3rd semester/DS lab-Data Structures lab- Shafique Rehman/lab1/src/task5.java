public class task5 {
    public static int[] add(int[] array, int element) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        return newArray;
    }
    public static int[] remove(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j] = array[i];
                j++;
            }
        }
        return newArray;
    }
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int array[] = new int[4];
       array[0] = 10;
        array[1] = 11;
        array[2] = 14;
        array[3] = 16;

        int element = 17;
        array = add(array, element);
        System.out.println("Array after adding element:");
        printArray(array);


        array = remove(array, 2);
        array = remove(array, 3);
        System.out.println("Array after removing elements:");
        printArray(array);


    }
}

