import java.util.Random;

//Find path from 0,0 to 3,3
//0's mean obstacles
//1's mean open path
public class MazeRunner {
    //Maze
    static int[][] A = {
            {1, 1, 1, 1},
            {0, 1, 0, 0},
            {0, 1, 0, 1},
            {0, 1, 1, 1}
    };
    //Path
    static int[][] path = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    public static int findPath(int i, int j, int n) {

        if (i == n - 1 && j == n - 1) {
            path[i][j] = 1;
            return 1;
        }

        if (A[i][j] == 1) { //if not end position
            path[i][j] = 1; //set path=1
            //check if within bounds, search right and below squares
            if (i + 1 < n && findPath(i + 1, j, n) == 1) return 1;
            if (j + 1 < n && findPath(i, j + 1, n) == 1) return 1;
            path[i][j] = 0;
        }
        //path not found
        return 0;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int f=0;

        for(int times=0;times<5;times++){

            int low = 0;
            int high = 3;
            int initial_i = r.nextInt(high-low) + low;
            int initial_j = r.nextInt(high-low) + low;
            System.out.println("Initial: Row: "+initial_i + " Col: " + initial_j );

            f=findPath(initial_i, initial_j, 4);

            if(f==0){System.out.println("Started at obstacle\n");}
            else{
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (path[i][j] == 1) {

                            System.out.print("row:"+ i + "," +"col:" +j + " ->  ");
                        }


                    }

                }
                System.out.println("\n");
            }

        }
    }
}