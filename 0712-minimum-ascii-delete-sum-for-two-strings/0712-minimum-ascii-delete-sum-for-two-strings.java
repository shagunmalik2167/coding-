class Solution {
    int dp[][];
    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(s1, s2, 0, 0);
    }
    public int fun(String s1, String s2, int i, int j) {
        int sum = 0;
        if(i == s1.length()) {
            while(j<s2.length()){
                sum+=s2.charAt(j);
                j++;
            }
            return sum;
        }
        if(j == s2.length()) {
            while(i<s1.length()){
                sum+=s1.charAt(i);
                i++;
            }
             return sum;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = fun(s1, s2, i + 1, j + 1);
        }
        int c1 = s1.charAt(i) + fun(s1, s2, i + 1, j);
        int c2 = s2.charAt(j) + fun(s1, s2, i, j + 1);
        return dp[i][j] = Math.min(c1, c2);
    }
}