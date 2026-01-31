import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals;

        // Sort using explicit comparator (faster than lambda)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] result = new int[n][2];
        int idx = 0;

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];

            if (curStart <= end) {
                // merge
                if (curEnd > end) end = curEnd;
            } else {
                // flush previous interval
                result[idx][0] = start;
                result[idx][1] = end;
                idx++;

                start = curStart;
                end = curEnd;
            }
        }

        // last interval
        result[idx][0] = start;
        result[idx][1] = end;
        idx++;

        // trim result
        return Arrays.copyOf(result, idx);
    }
}