class Solution {
    Set<String> ans = new HashSet<>();
    int maxLen = 0;

    public List<String> removeInvalidParentheses(String s) {
        int remove = 0, balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                balance++;
            else if (c == ')') {
                if (balance > 0)
                    balance--;
                else
                    remove++;
            }
        }

        maxLen = s.length() - remove - balance;
        solve(s, 0, "");
        return new ArrayList<>(ans);
    }

    void solve(String s, int i, String curr) {
        if (i == s.length()) {
            if (curr.length() == maxLen && valid(curr))
                ans.add(curr);
            return;
        }

        char c = s.charAt(i);
        solve(s, i + 1, curr + c);

        if (c == '(' || c == ')')
            solve(s, i + 1, curr);
    }

    boolean valid(String s) {
        int bal = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                bal++;
            if (c == ')' && --bal < 0)
                return false;
        }
        return bal == 0;
    }
}