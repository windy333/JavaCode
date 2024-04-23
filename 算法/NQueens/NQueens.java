/*
n皇后问题是一个经典的回溯算法问题，目标是在一个n×n的棋盘上放置n个皇后，
使得它们互不攻击。两个皇后互不攻击的条件是它们不在同一行、同一列或同一
对角线上。下面的代码示例解决了4皇后问题
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.'); // 初始化棋盘，所有位置都置为'.'
        }
        List<List<String>> solutions = new ArrayList<>();
        backtrack(board, 0, solutions);
        return solutions;
    }

    private void backtrack(char[][] board, int colIndex, List<List<String>> solutions) {
        if (colIndex == board.length) {
            solutions.add(createSolution(board)); // 找到一个解决方案
            return;
        }

        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            if (isValid(board, rowIndex, colIndex)) {
                board[rowIndex][colIndex] = 'Q'; // 放置皇后
                backtrack(board, colIndex + 1, solutions); // 对下一列递归
                board[rowIndex][colIndex] = '.'; // 回溯，撤销皇后
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        // 检查列
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上对角线
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上对角线
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> createSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            String rowString = new String(row);
            solution.add(rowString);
        }
        return solution;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> solutions = nQueens.solveNQueens(4);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
