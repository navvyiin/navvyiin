import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals;

        // Fast in-place sort by start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] res = new int[n][2];
        int size = 0;

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (s <= end) {
                if (e > end) end = e;
            } else {
                res[size][0] = start;
                res[size][1] = end;
                size++;
                start = s;
                end = e;
            }
        }

        res[size][0] = start;
        res[size][1] = end;
        size++;

        return Arrays.copyOf(res, size);
    }
}