class Solution {
    public int countStaircase(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            ArrayList<Integer> order = new ArrayList<>();

            for (int j = i; j < n; j++) {
                int x = nums[j];

                if (!freq.containsKey(x)) {
                    freq.put(x, 1);
                    order.add(x);
                } else {
                    freq.put(x, freq.get(x) + 1);
                }

                boolean valid = true;

                for (int k = 0; k < order.size(); k++) {
                    if (freq.get(order.get(k)) != k + 1) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
