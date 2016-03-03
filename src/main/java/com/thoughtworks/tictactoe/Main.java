package com.thoughtworks.tictactoe;


import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Board board = new Board(printStream);
        board.draw();

        Game game = new Game(board, reader, printStream);
        game.playGame();

    }
}
