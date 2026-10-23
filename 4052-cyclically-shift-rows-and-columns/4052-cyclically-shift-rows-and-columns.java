class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] temp = new int[n][n];
        int[][] ans = new int[n][n];

       for (int i = 0; i < n; i++) {
            int k = rowShift[i] % n;

            for (int j = 0; j < n; j++) {
                temp[i][(j - k + n) % n] = grid[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            int k = colShift[j] % n;

            for (int i = 0; i < n; i++) {
                ans[(i - k + n) % n][j] = temp[i][j];
            }
        }

        return ans;
    }
}