class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
         int n = prices.length;
        int m = discounts.length;
        int count = Math.min(n, m);

        double total = 0.0;

       
        for (int i = 0; i < n - count; i++) {
            total += prices[i];
        }

        for (int i = 0; i < count; i++) {
            int price = prices[n - 1 - i];
            int discount = discounts[m - 1 - i];

            total += (double) price * (100 - discount) / 100.0;
        }

        return total;
    }
}
