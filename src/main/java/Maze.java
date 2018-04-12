/* Java program to solve Rat in a Maze problem using
   backtracking */

public class Maze
{

    /* A utility function to print solution matrix
       sol[N][N] */
    void printSolution(int sol[][])
    {
        for (int i = 0; i < sol.length; i++)
        {
            for (int j = 0; j < sol[0].length; j++)
                System.out.print(" " + sol[i][j] +
                        " ");
            System.out.println();
        }
    }

    /* A utility function to check if x,y is valid
        index for N*N maze */
    boolean isSafe(int maze[][], int x, int y)
    {
        // if (x,y outside maze) return false
        return (x >= 0 && x < maze.length && y >= 0 &&
                y < maze[1].length && maze[x][y] == 1);
    }

    /* This function solves the Maze problem using
       Backtracking. It mainly uses solveMazeUtil()
       to solve the problem. It returns false if no
       path is possible, otherwise return true and
       prints the path in the form of 1s. Please note
       that there may be more than one solutions, this
       function prints one of the feasible solutions.*/
    boolean solveMaze(int maze[][])
    {
        int sol[][] = new int[maze.length][maze[0].length];

        if (!solveMazeUtil(maze, 0, 0, sol))
        {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    /* A recursive utility function to solve Maze
       problem */
    boolean solveMazeUtil(int maze[][], int x, int y,
                          int sol[][])
    {
        // if (x,y is goal) return true
        if (x == sol.length - 1 && y == sol[1].length - 1)
        {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y))
        {
            // mark x,y as part of solution path
            sol[x][y] = 1;

            /* Move forward in x direction */
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            /* If moving in x direction doesn't give
               solution then  Move down in y direction */
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;
            if (solveMazeUtil(maze, x - 1, y, sol))
                return true;
            if (solveMazeUtil(maze, x, y - 1, sol))
                return true;

            /* If none of the above movements work then
               BACKTRACK: unmark x,y as part of solution
               path */
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String args[])
    {
        Maze rat = new Maze();
        int maze[][] =
               {{1, 0, 1, 1,1},
                {1, 1, 1, 0,1},
                {0, 0, 0, 1,1},
                {1, 1, 1, 1,1},
                       {1, 1, 1, 1,1}
        };
        rat.solveMaze(maze);
    }
}
