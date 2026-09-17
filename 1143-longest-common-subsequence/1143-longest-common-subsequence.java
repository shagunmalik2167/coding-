class Solution {
  int [][] dp;
public int longestCommonSubsequence(String s, String t) {
       int[][] dp = new int[s.length()][t.length()];
       
       for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
               }
     
         return fun(0, 0, s, t, dp);
        }

    public int fun(int i, int j, String s, String t,int[][]dp) {
        if (i >=s.length() || j >=t.length()) {
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
        return 1 + fun(i + 1, j + 1, s, t, dp);
         }
            int c1 = fun(i +1, j, s,t ,dp);
            int c2 = fun(i, j +1, s,t,dp);

         return  dp[i][j]=Math.max(c1, c2);
           
      }
}