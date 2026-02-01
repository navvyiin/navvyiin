/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    let totalMoves = m + n - 2;
    let movesDown = Math.min(m - 1, n - 1);
    
    let result = 1;
    for (let i = 1; i <= movesDown; i++) {
        result = result * (totalMoves - movesDown + i) / i;
    }
    
    return Math.round(result);
};