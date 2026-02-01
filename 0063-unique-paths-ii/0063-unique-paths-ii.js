/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(grid) {
    const m = grid.length;
    const n = grid[0].length;

    if (grid[0][0] === 1) return 0;

    grid[0][0] = 1;

    // First row
    for (let j = 1; j < n; j++) {
        grid[0][j] = grid[0][j] === 0 ? grid[0][j - 1] : 0;
    }

    // First column
    for (let i = 1; i < m; i++) {
        grid[i][0] = grid[i][0] === 0 ? grid[i - 1][0] : 0;
    }

    // Rest of the grid
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            grid[i][j] = grid[i][j] === 0
                ? grid[i - 1][j] + grid[i][j - 1]
                : 0;
        }
    }

    return grid[m - 1][n - 1];
};