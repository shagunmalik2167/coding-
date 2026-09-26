class Solution {
    public boolean canTransform(int[] source, int[] target) {
        int [] a = source;
        if(source.length == 1){
            return source[0]==target[0];
            
        }
        long sum1 = 0;
        long sum2 = 0;
        for(int x: source){
            sum1 += x;
            
        }
        for(int x: target){
            sum2 += x;
        }
        return sum1 == sum2;
    }
}