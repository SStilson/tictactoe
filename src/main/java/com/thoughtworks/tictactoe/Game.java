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

    public void playGame() throws IOException {
        Integer i = 0;
        while(i < 8) {
            playerMove("X");
            playerMove("O");
            i+=2;
        }
        playerMove("X");
        board.draw();
        printStream.println("Game is a draw.");
    }

    public void playerMove(String playerSymbol) throws IOException {
        List<String> spaces = board.showSpacesOfBoard();
        Boolean validMove = false;
        while (!validMove) {
            printStream.println("Please enter your move: ");
            String playerInput = reader.readLine();
            String spaceToMoveInto = spaces.get(Integer.parseInt(playerInput)-1);
            if (!spaceToMoveInto.equals("X") && !spaceToMoveInto.equals("O")) {
                for (int i = 0; i < spaces.size(); i++) {
                    if (spaces.get(i).equals(playerInput)) {
                        spaces.set(i, playerSymbol);
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
