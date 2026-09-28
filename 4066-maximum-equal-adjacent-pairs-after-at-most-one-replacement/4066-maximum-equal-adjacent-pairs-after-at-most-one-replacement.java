class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {

        int base = 0;

        HashMap<Integer, HashMap<Integer, Integer>> gain = new HashMap<>();

        for (int i = 1; i < nums.length; i++) {

            int a = nums[i - 1];
            int b = nums[i];
            
            if (a == b) {
                base++;
            } 
            else {
        
                gain.putIfAbsent(a, new HashMap<>());
                gain.get(a).put(  b, gain.get(a).getOrDefault(b, 0) + 1 );

    
                gain.putIfAbsent(b, new HashMap<>());
                gain.get(b).put( a, gain.get(b).getOrDefault(a, 0) + 1 );
            }
        }

        int bestGain = 0;

        for (int x : gain.keySet()) {
            for (int y : gain.get(x).keySet()) {

                bestGain = Math.max(
                    bestGain,
                    gain.get(x).get(y)
                );
            }
        }

        return base + bestGain;
    }
}