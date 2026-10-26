class Solution {
    public long maximizeSum(int[] nums, int k) {
        long sum = 0;
        int n = nums.length;
        int[] gain = new int[n];

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            char[] digits = String.valueOf(nums[i]).toCharArray();
            Arrays.sort(digits);

            int maxNum = 0;
            for (int j = digits.length - 1; j >= 0; j--) {
                maxNum = maxNum * 10 + (digits[j] - '0');
            }

            gain[i] = maxNum - nums[i];
        }

        Arrays.sort(gain);

        for (int i = n - 1; i >= 0 && k > 0; i--) {
            if (gain[i] > 0) {
                sum += gain[i];
                k--;
            }
        }

        return sum;
    }
}

