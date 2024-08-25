public class task4 {
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
