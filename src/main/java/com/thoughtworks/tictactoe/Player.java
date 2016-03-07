package com.thoughtworks.tictactoe;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Player {

    private Board board;
    private PrintStream printStream;
    private BufferedReader reader;
    private String playerSymbol;

    public Player(Board board, PrintStream printStream, BufferedReader reader, String playerSymbol) {
        this.board = board;
        this.printStream = printStream;
        this.reader = reader;
        this.playerSymbol = playerSymbol;
    }

    public void move() throws IOException {
        List<String> locations = board.showLocationsOnBoard();
        Boolean validMove = false;
        while (!validMove) {
            printStream.println("Please enter your move: ");
            String playerInput = reader.readLine();
            Integer spaceToMoveIntoIndex = Integer.parseInt(playerInput) - 1;
            String spaceToMoveInto = locations.get(spaceToMoveIntoIndex);
            if (!spaceToMoveInto.equals("X") && !spaceToMoveInto.equals("O")) {
                locations.set(spaceToMoveIntoIndex, playerSymbol);
                board.setLocationsOnBoard(locations);
                validMove = true;
            } else {
                printStream.println("Location already taken!");
            }
        }
        board.draw();
    }
}
