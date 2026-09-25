class Solution {
    int[][] dp;

    public int numDistinct(String s, String t) {
       dp = new int[s.length()][t.length()];

        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(0, 0, s, t);
    }

    public int fun(int i, int j, String s, String t) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            int c1 = fun(i + 1, j + 1, s, t);
            int c2 = fun(i + 1, j, s, t);

            return dp[i][j] = c1 + c2;
        }
        return dp[i][j] = fun(i + 1, j, s, t);
    }
}