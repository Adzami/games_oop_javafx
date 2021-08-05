package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                if (checkHorizontal(board, i) || checkVertical(board, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkHorizontal(int[][] board, int index) {
        for (int[] cells : board) {
            if (cells[index] == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkVertical(int[][] board, int index) {
        for (int i = 0; i < board.length; i++) {
            if (board[index][i] == 0) {
                return false;
            }
        }
        return true;
    }
}
