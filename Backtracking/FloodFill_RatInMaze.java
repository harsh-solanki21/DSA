package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class FloodFill_RatInMaze {

    // This problem is same as Rat in a Maze problem.
    // 0 is the path where we can walk, 1 is obstacle.
    // Directions where we can go: top, down, left, right

    // TC - O(4^(m * n))
    // SC - O(4^(m * n))

    static List<String> floodFill(int[][] maze) {
        List<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        findPath(maze, 0, 0, visited, ans, "");
        return ans;
    }


    private static void findPath(int[][] maze, int row, int col, boolean[][] visited, List<String> ans, String pathSoFar) {
        if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || visited[row][col]) {
            return;
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            ans.add(pathSoFar);
            return;
        }

        visited[row][col] = true;
        findPath(maze, row - 1, col, visited, ans, pathSoFar + "U");
        findPath(maze, row, col - 1, visited, ans, pathSoFar + "L");
        findPath(maze, row + 1, col, visited, ans, pathSoFar + "D");
        findPath(maze, row, col + 1, visited, ans, pathSoFar + "R");
        visited[row][col] = false;
    }


    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(floodFill(maze));
    }

}
