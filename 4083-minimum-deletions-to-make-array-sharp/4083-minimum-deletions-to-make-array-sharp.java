class Solution {
    public int minDeletions(int[] nums) {
        int count = 0;
        int i = 1;

        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                count++;
                i++;
            } else {
                i++;
            }
        }

        return count;
    }
}