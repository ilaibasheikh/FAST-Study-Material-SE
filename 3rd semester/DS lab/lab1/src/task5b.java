public class task5b {
     int[] array;
     int sizeofarray;
     int count = 0;  // Initialize count to 0

    // Constructor to initialize the dynamic array
    public task5b(int initialSize) {
        sizeofarray = initialSize;
        array = new int[sizeofarray];
        count = 0; // Initialize count to 0 when the array is created
    }

    // Function to add an element to the dynamic array
    public void add(int element) {
        if (count == sizeofarray) {
            growSize(); // If the array is full, grow its size
        }

        array[count] = element;
        count++; // Increment count to reflect the added element
    }

    // Function to resize the dynamic array
    private void growSize() {
        int[] temp = new int[sizeofarray * 2];

        for (int i = 0; i < sizeofarray; i++) {
            temp[i] = array[i];
        }

        array = temp;
        sizeofarray = sizeofarray * 2;
    }

    // Function to print the elements in the dynamic array
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public void remove() {
        for (int i = 0; i < count-2; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        task5b dynamicArray = new task5b(4);

        // Add elements to the dynamic array
        dynamicArray.add(10);
        dynamicArray.add(11);
        dynamicArray.add(14);
        dynamicArray.add(16);

        // Print the dynamic array
        System.out.println("Original array:");
        dynamicArray.print();
        System.out.println();

        dynamicArray.add(23);
        System.out.println("Updated:");
        dynamicArray.print();
        System.out.println("Two elements removed");
        dynamicArray.remove();


    }
}

