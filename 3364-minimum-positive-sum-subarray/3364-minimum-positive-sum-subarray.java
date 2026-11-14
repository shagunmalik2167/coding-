
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        TreeMap<Long, Integer> map = new TreeMap<>();

        long ans = Long.MAX_VALUE;

        for (int i = l; i <= n; i++) {

           
            long val = prefix[i - l];

            map.put(val, map.getOrDefault(val, 0) + 1);

           
            int idx = i - r - 1;

            if (idx >= 0) {
                long rem = prefix[idx];

                if (map.get(rem) == 1) {
                    map.remove(rem);
                } else {
                    map.put(rem, map.get(rem) - 1);
                }
            }
            Long key = map.lowerKey(prefix[i]);

            if (key != null) {
                ans = Math.min(ans, prefix[i] - key);
            }
        }

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}
