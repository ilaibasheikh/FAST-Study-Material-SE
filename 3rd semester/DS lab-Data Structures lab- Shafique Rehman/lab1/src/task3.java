public class task3 {
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
