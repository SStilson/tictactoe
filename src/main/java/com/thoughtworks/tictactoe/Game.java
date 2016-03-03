package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Game {

    private Board board;
    private BufferedReader reader;

    public Game(Board board, BufferedReader reader) {
        this.board = board;
        this.reader = reader;
    }

    public void playerOneMove() throws IOException {
        String playerOneInput = reader.readLine();
        List<String> spaces = board.showSpacesOfBoard();

        for (int i = 0; i < spaces.size(); i++) {
            if (spaces.get(i).equals(playerOneInput)) {
                spaces.set(i, "X");
            }
        }

        board.draw();
    }

    public void playerTwoMove() throws IOException {
        String playerTwoInput = reader.readLine();
        List<String> spaces = board.showSpacesOfBoard();

        for (int i = 0; i < spaces.size(); i++) {
            if (spaces.get(i).equals(playerTwoInput)) {
                spaces.set(i, "O");
            }
        }

        board.draw();
    }
}
