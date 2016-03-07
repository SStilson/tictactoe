package com.thoughtworks.tictactoe;


import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board(printStream);
        Player player1 = new Player(board, printStream, reader, "X");
        Player player2 = new Player(board, printStream, reader, "O");
        Game game = new Game(board, reader, printStream, player1, player2);

        game.playGame();
    }
}
