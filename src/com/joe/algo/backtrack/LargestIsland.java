package com.joe.algo.backtrack;

/**
 * @author Joe
 * LeetCode 827 超时了我丢
 * 2021/10/30 19:29
 */
public class LargestIsland {
    public int largestIsland(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        boolean hasWater = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // 填充并且尝试
                    hasWater = true;
                    grid[i][j] = 1;
                    res = Math.max(res, dfs(grid, i, j, new boolean[m][n]));
                    grid[i][j] = 0;
                }
            }
        }

        if (!hasWater) {
            return m * n;
        }

        return res;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if (grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        return 1 + dfs(grid, i, j + 1, visited) + dfs(grid, i, j - 1, visited)
                + dfs(grid, i + 1, j, visited) + dfs(grid, i - 1, j, visited);
    }

    public static void main(String[] args) {
        LargestIsland largestIsland = new LargestIsland();
        System.out.println(largestIsland.largestIsland(new int[][] {
                {0,0,0,0,0,0,0}
                ,{0,1,1,1,1,0,0}
                ,{0,1,0,0,1,0,0}
                ,{1,0,1,0,1,0,0}
                ,{0,1,0,0,1,0,0}
                ,{0,1,0,0,1,0,0}
                ,{0,1,1,1,1,0,0}
        }));
    }
}
