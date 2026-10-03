class Solution {
    public boolean wordBreak(String s, List<String> wd) {
        Boolean[] dp = new Boolean[s.length()];
         return fun(0, s, wd, dp);
    }

    public boolean fun(int i, String s, List<String> wd, Boolean[] dp) {
           if (i == s.length()) {
            return true;
        }
         if (dp[i] != null) {
            return dp[i];
        }

        
        for (int j = i + 1; j <= s.length(); j++) {
           String word = s.substring(i, j);
       if (wd.contains(word)) {

                if (fun(j, s, wd, dp)) {
                    return dp[i] = true;
                }
            }
        }
        return dp[i] = false;
    }
}