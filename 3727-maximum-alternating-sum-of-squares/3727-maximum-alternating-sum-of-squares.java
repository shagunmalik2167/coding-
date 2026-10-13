
class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] arr = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = Math.abs((long) nums[i]);
        }

        Arrays.sort(arr);

        long score = 0;
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            score -= arr[i] * arr[i];
        }

        for (int i = n / 2; i < n; i++) {
            score += arr[i] * arr[i];
        }

        return score;
    }
}
