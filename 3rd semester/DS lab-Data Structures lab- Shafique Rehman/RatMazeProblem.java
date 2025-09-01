public class RatMazeProblem   
{  
  
// Size of the maze  
static int R;  
static int C;  
  
// A utility method to display  
// the outcome matrix result[R][C]   
void displaySolution(int result[][])  
{  
System.out.println("The resultant matrix is: ");  
for (int r = 0; r < R; r++)   
{  
for (int c = 0; c < C; c++)  
{  
System.out.print(" " + result[r][c] + " ");  
}  
  
System.out.println();  
}  
}  
  
// A utility method to validate  
// whether r, c is the valid index for the R * C maze   
boolean isValid(int maze[][], int r, int c)  
{  
// if (r, c is outside the maze, then return false  
return (r >= 0 && r < R && c >= 0 && c < C && maze[r][c] == 0);  
}  
  
// The method solves the rat maze problem with the  
// help of Backtracking. It uses the solveMazeUtility()  
// method to find the solution to the problem. The method returns false   
// when there is no single valid path from source to destination, otherwise true is   
// returned   
  
// and displays the path using 0s. Note that there can be more than one path  
// from source to destination. However, the method displays one of the feasible ones.   
boolean findPathMaze(int maze[][])  
{  
int maz[][] = new int[R][C];  
for(int r = 0; r < R; r++)  
{  
for(int c = 0; c < C; c++)  
{  
maz[r][c] = 1;  
}  
}  
  
  
if (solveMazeUtility(maze, 0, 0, maz) == false)   
{  
System.out.print("Path from source to destination doesn't exist");  
return false;  
}  
  
displaySolution(maz);  
return true;  
}  
  
// A recursive utility method to find the solution of the Maze  
// problem   
boolean solveMazeUtility(int maze[][], int r, int c,  
        int res[][])  
{  
// if r, c is the destination, then return true  
if (r == R - 1 && c == C - 1 && maze[r][c] == 0)   
{  
res[r][c] = 0;  
return true;  
}  
  
// Check if the maze[r][c] is valid  
if (isValid(maze, r, c) == true)   
{  
// checking whether the current cell has been the part of the solution path or not  
if (res[r][c] == 0)  
{  
return false;  
}  
  
// marking res(r, c) as the part of the solution path  
res[r][c] = 0;  
  
// Moving forward in the downward direction   
if (solveMazeUtility(maze, r + 1, c, res))  
{  
return true;  
}  
// If moving in downward direction does not provide  
// the solution then we move in the rightward direction  
if (solveMazeUtility(maze, r, c + 1, res))  
{  
return true;  
}  
// If moving in the downward direction does not provide  
// the solution then start moving upward   
if (solveMazeUtility(maze, r - 1, c, res))  
{  
return true;  
}  
// If moving in the rigtward direction does not provide  
// solution then start moving in the left   
if (solveMazeUtility(maze, r, c - 1, res))  
{  
return true;  
}  
// if a valid path is not possible from  
// the cell (r, c), then mark it as 1  
res[r][c] = 1;  
return false;  
}  
return false;  
}  
// main method  
public static void main(String argvs[])  
{  
// creating an object of the class RatMazeProblem  
RatMazeProblem r = new RatMazeProblem();  
// creating the maze  
int maze[][] = { { 0, 1, 1, 1 },  
               { 0, 0, 1, 0 },  
               { 1, 0, 1, 1 },  
               { 0, 0, 0, 0 } };  
  
R = maze.length;  
C = maze[0].length;  
r.findPathMaze(maze);  
}  
}  