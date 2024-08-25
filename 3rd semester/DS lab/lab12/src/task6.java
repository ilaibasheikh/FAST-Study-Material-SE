
//public class task6 {
//
//    public void dfs(int[][] grid, int row, int col) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
//            return;
//        }
//
//        grid[row][col] = 0;
//
//        dfs(grid, row - 1, col);
//        dfs(grid, row + 1, col);
//        dfs(grid, row, col - 1);
//        dfs(grid, row, col + 1);
//        dfs(grid, row - 1, col - 1);
//        dfs(grid, row - 1, col + 1);
//        dfs(grid, row + 1, col - 1);
//        dfs(grid, row + 1, col + 1);
//    }
//    public int numberOfIslands(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//
//        int rows = grid.length;
//        int cols = grid[0].length;
//        int count = 0;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (grid[i][j] == 1) {
//                    count++;
//                    dfs(grid, i, j);
//                }
//            }
//        }
//        return count;
//    }
//    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 1},
//                {1, 0},
//                {1, 1},
//                {1, 0}
//        };
//
//        task6 islandCounter = new task6();
//        int numIslands = islandCounter.numberOfIslands(grid);
//        System.out.println("Grid : \n" +
//                "{0, 1},\n" +
//                "{1, 0},\n" +
//                "{1, 1},\n" +
//                "{1, 0}\n"
//        );
//        System.out.println("num of islands: " + numIslands);
//    }
//}
