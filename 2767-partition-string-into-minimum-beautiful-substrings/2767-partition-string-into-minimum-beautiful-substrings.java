class Solution {

    boolean check(int l, int r, String s) {
       if (s.charAt(l) == '0') {
            return false;
        }

        int num = 0;
        int power = 0;

        for (int i = r; i >= l; i--) {
           if (s.charAt(i) == '1') {
                num += Math.pow(2, power);
            }

            power++;
        }

        for (int i = 0; i <= 10; i++) {
        int k = (int) Math.pow(5, i);
       if (num == k) {
                return true;
            }
        }
       return false;
    }

    int fun(int p, int i, String s) {
       if (i == s.length() - 1) {

            if (check(p, i, s)) {
                return 0;
            }

            return 1000000000;
        }

        int m = 1000000000;
        if (check(p, i, s)) {
         int a = 1 + fun(i + 1, i + 1, s);
           m = Math.min(m, a);
        }
        int a = fun(p, i + 1, s);
         m = Math.min(m, a);
            return m;
    }

    public int minimumBeautifulSubstrings(String s) {
          int ans = fun(0, 0, s);

        if (ans == 1000000000) {
            return -1;
        }

        return ans + 1;
    }
}