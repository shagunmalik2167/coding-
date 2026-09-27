class Solution {
    public int[] rearrangeArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x , map.getOrDefault(x ,0)+1);
        }

       ArrayList<Integer> values = new ArrayList<>(map.keySet());
        Collections.sort(values);
        ArrayList<Integer> ans = new ArrayList<>();
        while(true){
            boolean added = false;
            for(int x: values){
                if(map.get(x) > 0){
                    ans.add(x);
                    map.put(x , map.get(x)-1);
                    added = true;
                }
            }
            if(!added){
                break;
            }
        }
        int [] result = new int[ans.size()];
        for(int i =0; i<ans.size(); i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}