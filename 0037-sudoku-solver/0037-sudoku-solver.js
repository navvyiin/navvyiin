/**
 * @param {character[][]} board
 * @return {void}
 */
var solveSudoku = function(board) {

    function isValid(row, col, ch) {
        for (let i = 0; i < 9; i++) {
            // Row
            if (board[row][i] === ch) return false;
            // Column
            if (board[i][col] === ch) return false;
            // 3x3 box
            const boxRow = 3 * Math.floor(row / 3) + Math.floor(i / 3);
            const boxCol = 3 * Math.floor(col / 3) + (i % 3);
            if (board[boxRow][boxCol] === ch) return false;
        }
        return true;
    }

    function backtrack() {
        for (let row = 0; row < 9; row++) {
            for (let col = 0; col < 9; col++) {
                if (board[row][col] === '.') {
                    for (let ch of ['1','2','3','4','5','6','7','8','9']) {
                        if (isValid(row, col, ch)) {
                            board[row][col] = ch;

                            if (backtrack()) return true;

                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    backtrack();
};