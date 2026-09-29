class Solution {
    public long countIntersectingIntervals(int[][] intervals) {

        int n = intervals.length;
          Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ends = new int[n];
         for (int i = 0; i < n; i++) {
            ends[i] = intervals[i][1];
        }
          Arrays.sort(ends);
           long count = 0;

        for (int i = 0; i < n; i++) {
          int start = intervals[i][0];
                int left = 0;
            int right = i;

        
            while (left < right) {
      int mid = left + (right - left) / 2;
         if (ends[mid] >= start) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            count += i - left;
        }

        return count;
    }
}