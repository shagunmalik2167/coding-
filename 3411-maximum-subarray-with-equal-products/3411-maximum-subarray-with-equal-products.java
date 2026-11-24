

class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            long product = 1;
            long lcm = 1;
            long gcdValue = 0;

            for (int j = i; j < n; j++) {
                gcdValue = gcd(gcdValue, nums[j]);

                long g = gcd(lcm, nums[j]);
                lcm = (lcm / g) * nums[j];

                product *= nums[j];

                if (product == lcm * gcdValue) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
