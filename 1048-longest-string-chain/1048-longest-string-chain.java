class Solution {
    int dp[][];
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        dp = new int[words.length][words.length + 1];
        for(int i = 0; i < words.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(words, 0, -1);
    }
    public int fun(String[] words, int i, int prev) {
        if(i == words.length) {
            return 0;
        }
        if(dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }

        int c1 = fun(words, i + 1, prev);
        int c2 = 0;

        if(prev == -1 || check(words[prev], words[i])) {
            c2 = 1 + fun(words, i + 1, i);
        }
        return dp[i][prev + 1] = Math.max(c1, c2);
    }

    public boolean check(String a, String b) {

        if(b.length() != a.length() + 1) {
            return false;
        }
        int i = 0;
        int j = 0;

        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == a.length();
    }
}