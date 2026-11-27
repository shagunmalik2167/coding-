class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] bonus = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && items[i][0] % items[j][0] == 0) {
                    bonus[j]++;
                }
            }
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int free = bonus[i];

            int[] next = dp.clone();

            for (int r = 0; r < price && r <= budget; r++) {
                int best = Integer.MIN_VALUE;

                for (int t = 0, b = r; b <= budget; t++, b += price) {
                    if (t > 0) {
                        best = Math.max(best, dp[b - price] - (t - 1));
                    }

                    if (best != Integer.MIN_VALUE) {
                        next[b] = Math.max(next[b], best + free + t);
                    }
                }
            }

            dp = next;
        }

        return dp[budget];
    }
}