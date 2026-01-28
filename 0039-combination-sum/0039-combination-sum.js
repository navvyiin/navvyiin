/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    const result = [];
    candidates.sort((a, b) => a - b);

    function backtrack(start, remaining, path) {
        if (remaining === 0) {
            result.push([...path]);
            return;
        }

        if (remaining < 0) return;

        for (let i = start; i < candidates.length; i++) {
            const num = candidates[i];
            path.push(num);
            backtrack(i, remaining - num, path); // reuse allowed
            path.pop();
        }
    }

    backtrack(0, target, []);
    return result;
};