package io.ravi.logicmojo.backtracking;

import java.util.Arrays;

public class NQueens {

    public static void main(String[] args) {
        nQueen(4);
    }

    static void nQueen(int nQueen) {
        char[][] borad = new char[nQueen][nQueen];
        for (int i = 0; i < nQueen; i++) {
            Arrays.fill(borad[i], '-');
        }

        nQueen(borad, 0);
    }

    static void nQueen(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nQueen(board, row + 1);
                board[row][i] = '-';
            }
        }
    }

    static boolean isSafe(char[][] board, int r, int c) {
        //Same column check
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }
        //Same \ diagonal check
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
       // System.out.println("Board length : " + board.length);
        //Same / diagonal check
        for (int i = r, j = c; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row).replaceAll(",", ""));
        }
        System.out.println();
    }


}
