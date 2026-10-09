class Solution {
    static int[][] dp;

    public int Path(int[][] grid, int r, int c) {
        int n = grid.length;
        int m = grid[0].length;

        if (r >= n || c >= m) return Integer.MAX_VALUE;

        if (r == n - 1 && c == m-1)
            return grid[r][c];

        if (dp[r][c] != -1)
            return dp[r][c];

        int down = Path(grid, r + 1, c);
        int right = Path(grid, r , c + 1);

        return dp[r][c] = grid[r][c] + Math.min(down, right);
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
        Arrays.fill(dp[i], -1);
        }

        return Path(grid ,0 ,0);
    }
}