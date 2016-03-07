package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Game {

    private Board board;
    private BufferedReader reader;
    private PrintStream printStream;
    private Player player1;
    private Player player2;

    public Game(Board board, BufferedReader reader, PrintStream printStream, Player player1, Player player2) {
        this.board = board;
        this.reader = reader;
        this.printStream = printStream;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playGame() throws IOException {
        board.draw();
        player1.move();
        player2.move();
/*        Integer i = 0;
        while(i < 8) {
            playerMove("X");
            if(board.checkWinConditions()) {
                printStream.println("Player X is the winner!");
                break;
            }
            playerMove("O");
            if(board.checkWinConditions()) {
                printStream.println("Player O is the winner!");
                break;
            }
            i+=2;
        }
        if (!board.checkWinConditions()) {
            playerMove("X");
            if (board.checkWinConditions()) {
                printStream.println("Player X is the winner!");
            } else {
                board.draw();
                printStream.println("Game is a draw.");
            }
        }*/
    }





}
