class Solution {
     int  dp[][];
    public int longestPalindromeSubseq(String s) {
       String t = new StringBuilder(s).reverse().toString();

       dp = new int[s.length()][s.length()];
       
       for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
               }
     
         return fun(s, 0, s.length()-1);
        }

    public int fun(String s, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
        return 2 + fun(s, i + 1, j - 1);
         }
        
           int c1 = fun(s, i + 1, j );
            int c2 = fun(s, i, j - 1);

         return  dp[i][j]=Math.max(c1, c2);
         
      }
}
    