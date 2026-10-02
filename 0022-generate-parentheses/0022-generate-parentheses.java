class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        solve(ans, "", 0, 0, n);
               return ans;
    }

    void solve(List<String> ans, String str, int open, int close, int n) {
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }
              if (open < n) {
            solve(ans, str + "(", open + 1, close, n);
        }

        if (close < open) {
               solve(ans, str + ")", open, close + 1, n);
        }
    }
}