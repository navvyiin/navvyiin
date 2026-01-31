/**
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix = function(n) {
    const matrix = Array.from({ length: n }, () => Array(n));
    
    let top = 0, bottom = n - 1;
    let left = 0, right = n - 1;
    let num = 1;

    while (top <= bottom && left <= right) {
        // left → right
        for (let col = left; col <= right; col++) {
            matrix[top][col] = num++;
        }
        top++;

        // top → bottom
        for (let row = top; row <= bottom; row++) {
            matrix[row][right] = num++;
        }
        right--;

        if (top <= bottom) {
            // right → left
            for (let col = right; col >= left; col--) {
                matrix[bottom][col] = num++;
            }
            bottom--;
        }

        if (left <= right) {
            // bottom → top
            for (let row = bottom; row >= top; row--) {
                matrix[row][left] = num++;
            }
            left++;
        }
    }

    return matrix;
};