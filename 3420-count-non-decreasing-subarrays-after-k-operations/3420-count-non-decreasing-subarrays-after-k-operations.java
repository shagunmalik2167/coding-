
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        int LOG = 32 - Integer.numberOfLeadingZeros(n);

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int[] next = new int[n + 1];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        int[][] up = new int[LOG][n + 1];
        long[][] cost = new long[LOG][n + 1];

        for (int i = 0; i <= n; i++) {
            up[0][i] = i == n ? n : next[i];

            if (i < n) {
                int j = next[i];

                cost[0][i] = (long) nums[i] * (j - i - 1)
                        - (prefix[j] - prefix[i + 1]);
            }
        }

        for (int p = 1; p < LOG; p++) {
            for (int i = 0; i <= n; i++) {
                int mid = up[p - 1][i];

                up[p][i] = up[p - 1][mid];

                cost[p][i] = cost[p - 1][i]
                        + cost[p - 1][mid];
            }
        }
        long ans = 0;
        int right = -1;

        for (int left = 0; left < n; left++) {

            if (right < left) {
                right = left;
            }

            while (right + 1 < n &&
                   getCost(left, right + 1, nums,
                           prefix, up, cost, LOG) <= k) {
                right++;
            }

            ans += right - left + 1;
        }

        return ans;
    }

    private long getCost(int left, int right,
                         int[] nums, long[] prefix,
                         int[][] up, long[][] cost,
                         int LOG) {

        long result = 0;
        int pos = left;

        for (int p = LOG - 1; p >= 0; p--) {

            int nxt = up[p][pos];

            if (nxt <= right) {
                result += cost[p][pos];
                pos = nxt;
            }
        }

        result += (long) nums[pos] * (right - pos)
                - (prefix[right + 1] - prefix[pos + 1]);

        return result;
    }
}
