import java.util.Scanner;
//1d array
 class Test {
     public static void main(String args[]) {
        int arr[] = { 3, 1, 2, 5, 4 };
        sum(arr);}
    public static void sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        System.out.println("sum of array values : " + sum);}}
//2d array
 class task3 {
    public static void main(String[] args) {
        int array1[][] = new int[2][2];
        int array2[][] = new int[2][2];
        array1[0][0]=  1;
        array1[0][1]=  2;
        array1[1][0]=  3;
        array1[1][1]=  4;
        array2[0][0]=  6;
        array2[0][1]=  7;
        array2[1][0]=  8;
        array2[1][1]=  9;
        System.out.println("This is array 1:");
        for (int i=0; i< array1.length;i++){
            for(int j=0;j< array1[i].length ; j++){
                System.out.print(array1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("This is array 2: ");
        for (int i=0; i< array2.length;i++){
            for(int j=0;j< array2[i].length ; j++){
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Addition of two rows:" );
        for (int i=0; i< array2.length;i++){
            for(int j=0;j< array2[i].length ; j++){
                System.out.print(array2[i][j] + array1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
//jagged array
class Main1 {
    public static void main(String[] args)
    {
        int arr[][] = new int[2][];
        arr[0] = new int[3];
        arr[1] = new int[2];
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = count++;
        System.out.println("Contents of 2D Jagged Array");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
//jagged array
 class task4 {
    public static void main(String[] args) {
        int array[][]= {
                {4, 2, 1},
                {5, 8, 5, 8},
                {3 }
        };

        int sum = 0 ;
        System.out.println("Original array:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print( array[i][j]+ " ");
            }
            System.out.println();
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        System.out.println("Sum of all indexes: ");
        System.out.println(sum);
    }
}
//dynamic array // growsize //shrinksize
 class DynamicArrayExample1 {
    private int array[];
    private int count;
    private int sizeofarray;
    public void growSize()
    {
        int temp[] = null;
        if (count == sizeofarray)
        {
            temp = new int[sizeofarray * 2];
            {
                for (int i = 0; i < sizeofarray; i++)
                {
                    temp[i] = array[i];
                }
            }
        }
        array = temp;
        sizeofarray= sizeofarray * 2;
    }
    public void shrinkSize() {
        int temp[] = null;
        if (count > 0) {
            temp = new int[count];
            for (int i = 0; i < count; i++) {
                temp[i] = array[i];
            }
            sizeofarray = count;
            array = temp;
        }
    }
        //creating a function that inserts an element at the specified index
    public void addElementAt(int index, int a)
    {
//compare the size with the number of elements if not equal grows the array size
        if (count == sizeofarray)
        {
//invoking growSize() method
            growSize();
        }
        for (int i = count - 1; i >= index; i--)
        {
//shifting all the elements to the left from the specified index
            array[i + 1] = array[i];
        }
//inserts an element at the specified index
        array[index] = a;
        count++;
    }
}
//reversed array
 class GFG {

    /* Function to reverse arr[] from
        start to end*/
    static void rvereseArray(int arr[],
                             int start, int end)
    {
        int temp;

        while (start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /* Utility that prints out an
    array on a line */
    static void printArray(int arr[],
                           int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {

        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr, 6);
        rvereseArray(arr, 0, 5);
        System.out.print("Reversed array is \n");
        printArray(arr, 6);

    }
}
//searching
class Main2 {

    // Function to implement
    // search operation
    static int findElement(int arr[], int n, int key)
    {
        for (int i = 0; i < n; i++)
            if (arr[i] == key)
                return i;

        // If the key is not found
        return -1;
    }

    // Driver's Code
    public static void main(String args[])
    {
        int arr[] = { 12, 34, 10, 6, 40 };
        int n = arr.length;

        // Using a last element as search element
        int key = 40;

        // Function call
        int position = findElement(arr, n, key);

        if (position == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element Found at Position: "
                    + (position + 1));
    }
}
//inserting at end
class Main {
    // Function to insert a given key in
    // the array. This function returns n+1
    // if insertion is successful, else n.
    static int insertSorted(int arr[], int n, int key,
                            int capacity)
    {

        // Cannot insert more elements if n
        // is already more than or equal to
        // capacity
        if (n >= capacity)
            return n;

        arr[n] = key;

        return (n + 1);
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = new int[20];
        arr[0] = 12;
        arr[1] = 16;
        arr[2] = 20;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 70;
        int capacity = 20;
        int n = 6;
        int i, key = 26;

        System.out.print("Before Insertion: ");
        for (i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        // Inserting key
        n = insertSorted(arr, n, key, capacity);

        System.out.print("\n After Insertion: ");
        for (i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
//inserting at any position
class GFG1 {
    static void insertElement(int arr[], int n, int x,
                              int pos)
    {
        // shift elements to the right
        // which are on the right side of pos
        for (int i = n - 1; i >= pos; i--)
            arr[i + 1] = arr[i];
        arr[pos] = x;
    }
    public static void main(String[] args)
    {
        int arr[] = new int[15];
        arr[0] = 2;
        arr[1] = 4;
        arr[2] = 1;
        arr[3] = 8;
        arr[4] = 5;
        int n = 5;
        int x = 10, pos = 2;

        System.out.print("Before Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        // Inserting key at specific position
        insertElement(arr, n, x, pos);
        n += 1;

        System.out.print("\n\nAfter Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
//delete
class Main3 {
    // function to search a key to
    // be deleted
    static int findElement(int arr[], int n, int key)
    {
        int i;
        for (i = 0; i < n; i++)
            if (arr[i] == key)
                return i;

        return -1;
    }

    // Function to delete an element
    static int deleteElement(int arr[], int n, int key)
    {
        // Find position of element to be
        // deleted
        int pos = findElement(arr, n, key);

        if (pos == -1) {
            System.out.println("Element not found");
            return n;
        }

        // Deleting element
        int i;
        for (i = pos; i < n - 1; i++)
            arr[i] = arr[i + 1];

        return n - 1;
    }

    // Driver's Code
    public static void main(String args[])
    {
        int i;
        int arr[] = { 10, 50, 30, 40, 20 };

        int n = arr.length;
        int key = 30;

        System.out.println("Array before deletion");
        for (i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        // Function call
        n = deleteElement(arr, n, key);

        System.out.println("\n\nArray after deletion");
        for (i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
//rotating an array
 class task2 {
    public static void main(String[] args) {
        int array[] = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        System.out.println("This is the original array:");
        System.out.println(array.length);
        for (int i =0;i<array.length; i++){
            System.out.print( array[i] + " ");

        }
        System.out.println();
        System.out.println("Enter the number of steps to rotate ");
        Scanner a = new Scanner(System.in);
        int x;
        x= a.nextInt();

        System.out.println("This is the rotated array:");
        int end;
        for (int i =0;i< x; i++){
            end =array[array.length-1];

            for(int j = array.length-1; j > 0; j--){
                array[j] = array[j-1];
            }

            array[0] = end;
        }
        System.out.println("This is the rotated array:");

        for(int i = 0; i< array.length; i++){
            System.out.print(array[i] + " ");
        }

    }
}