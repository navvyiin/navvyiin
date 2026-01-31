/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function(intervals, newInterval) {
    const result = [];
    let i = 0;
    const n = intervals.length;

    let start = newInterval[0];
    let end = newInterval[1];

    // 1. Add all intervals before newInterval
    while (i < n && intervals[i][1] < start) {
        result.push(intervals[i]);
        i++;
    }

    // 2. Merge overlapping intervals
    while (i < n && intervals[i][0] <= end) {
        start = Math.min(start, intervals[i][0]);
        end = Math.max(end, intervals[i][1]);
        i++;
    }

    result.push([start, end]);

    // 3. Add remaining intervals
    while (i < n) {
        result.push(intervals[i]);
        i++;
    }

    return result;
};