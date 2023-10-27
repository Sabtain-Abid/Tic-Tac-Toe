package com.mycompany.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        
        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + ", enter your move (row and column):");
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    board[row][col] = player;
                    gameOver = haveWon(board, player);
                    if (gameOver) {
                        System.out.println("Player " + player + " has won!");
                    } else {
                        player = (player == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid row and column values.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        printBoard(board);
    }

 public static boolean haveWon(char[][] board, char player) {
    // Check rows and columns for a win
    for (int i = 0; i < 3; i++) {
        if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
            return true; // Horizontal win
        }
        if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
            return true; // Vertical win
        }
    }

    // Check diagonals for a win
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
        return true; // Diagonal (top-left to bottom-right) win
    }
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
        return true; // Diagonal (top-right to bottom-left) win
    }

    return false; // No win detected
}

    public static void printBoard(char[][] board) {
        System.out.println("---------------------");      
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[row].length; col++)
            {
                System.out.print(board[row][col] + "   |   ");
            }
            System.out.println();
            System.out.println("---------------------");
        }
    }
}
