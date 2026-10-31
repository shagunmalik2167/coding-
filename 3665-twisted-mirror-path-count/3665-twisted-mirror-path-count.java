class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long MOD = 1000000007;
        long[][] dp = new long[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 0) continue;

                int x = i;
                int y = j + 1;
                boolean right = true;

                while (x < m && y < n) {
                    if (grid[x][y] == 0) {
                        dp[x][y] = (dp[x][y] + dp[i][j]) % MOD;
                        break;
                    }

                    if (right) {
                        x++;
                    } else {
                        y++;
                    }

                    right = !right;
                }

              
                x = i + 1;
                y = j;
                right = false;

                while (x < m && y < n) {
                    if (grid[x][y] == 0) {
                        dp[x][y] = (dp[x][y] + dp[i][j]) % MOD;
                        break;
                    }

                    if (right) {
                        x++;
                    } else {
                        y++;
                    }

                    right = !right;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}