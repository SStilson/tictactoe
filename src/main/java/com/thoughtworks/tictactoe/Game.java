package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Game {

    private Board board;
    private BufferedReader reader;
    private PrintStream printStream;

    public Game(Board board, BufferedReader reader, PrintStream printStream) {
        this.board = board;
        this.reader = reader;
        this.printStream = printStream;
    }

    public void playerOneMove() throws IOException {
        List<String> spaces = board.showSpacesOfBoard();
        Boolean validMove = false;
        while (!validMove) {
            printStream.println("Please enter your move: ");
            String playerOneInput = reader.readLine();
            String spaceToMoveInto = spaces.get(Integer.parseInt(playerOneInput)-1);
            if (!spaceToMoveInto.equals("X") && !spaceToMoveInto.equals("O")) {
                for (int i = 0; i < spaces.size(); i++) {
                    if (spaces.get(i).equals(playerOneInput)) {
                        spaces.set(i, "X");
                    }
                }
                board.setSpacesOfBoard(spaces);
                validMove = true;
            } else {
                printStream.println("Location already taken!");
            }
        }

        board.draw();
    }

    public void playerTwoMove() throws IOException {
        List<String> spaces = board.showSpacesOfBoard();
        Boolean validMove = false;
        while (!validMove) {
            printStream.println("Please enter your move: ");
            String playerTwoInput = reader.readLine();
            String spaceToMoveInto = spaces.get(Integer.parseInt(playerTwoInput)-1);
            if (!spaceToMoveInto.equals("X") && !spaceToMoveInto.equals("O")) {
                for (int i = 0; i < spaces.size(); i++) {
                    if (spaces.get(i).equals(playerTwoInput)) {
                        spaces.set(i, "O");
                    }
                }
                board.setSpacesOfBoard(spaces);
                validMove = true;
            } else {
                printStream.println("Location already taken!");
            }
        }

        board.draw();
    }
}
