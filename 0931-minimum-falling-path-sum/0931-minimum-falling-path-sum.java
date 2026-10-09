class Solution {
    int[][] dp;

    public int path(int i, int j, int[][] mat) {
        int n = mat.length;

        if (j < 0 || j >= n)
            return Integer.MAX_VALUE;

        if (i == n - 1)
            return mat[i][j];

        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];

        int down = path(i + 1, j, mat);
        int left = path(i + 1, j - 1, mat);
        int right = path(i + 1, j + 1, mat);

        int next = Math.min(down, Math.min(left, right));

        return dp[i][j] = mat[i][j] + next;
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++)
            ans = Math.min(ans, path(0, j, matrix));

        return ans;
    }
}
