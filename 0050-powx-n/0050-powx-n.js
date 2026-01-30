/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    let N = n;
    if (N < 0) {
        x = 1 / x;
        N = -N;
    }

    let result = 1;

    while (N > 0) {
        if (N % 2 === 1) {
            result *= x;
        }
        x *= x;
        N = Math.floor(N / 2);
    }

    return result;
};