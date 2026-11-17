class Solution {
    public long maxDifference(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            long sum1 = nums[i];

            if (sum1 % 3 == 0) {
                sum1 -= dp[i + 1];
            } else {
                sum1 += dp[i + 1];
            }
            long sum2 = Long.MIN_VALUE;

            if (i + 1 < n) {
                sum2 = (long) nums[i] + nums[i + 1];

                if (sum2 % 3 == 0) {
                    sum2 -= dp[i + 2];
                } else {
                    sum2 += dp[i + 2];
                }
            }

            dp[i] = Math.max(sum1, sum2);
        }

        return dp[0];
    }
}