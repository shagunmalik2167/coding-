class Solution {
   int[][] dp = new int[501][501];
     int fun(int i, int p, int[] nums, int m, int k) {
         if (i >= nums.length)
            return 0;

        int len = i - p + 1;
           if (dp[i][p] != -1)
            return dp[i][p];

        m = Math.max(m, nums[i]);

        int ans = 0;
         if (len == k) {

            int a = m * len + fun(i + 1, i + 1, nums, 0, k);
            ans = Math.max(ans, a);

        } else {
        int a = m * len + fun(i+1, i+1, nums, 0, k);

            int b = fun(i+1, p,nums, m, k);

            ans = Math.max(ans, a);
            ans = Math.max(ans, b);
        }

        return dp[i][p] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        for (int i =0; i<501; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return fun(0, 0, arr, 0, k);
    }
}