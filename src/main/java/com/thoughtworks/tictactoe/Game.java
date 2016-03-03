package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Game {

    private Board board;
    private BufferedReader reader;
    private PrintStream printStream;
    private Boolean XWins = false;
    private Boolean OWins = false;

    public Game(Board board, BufferedReader reader, PrintStream printStream) {
        this.board = board;
        this.reader = reader;
        this.printStream = printStream;
    }

    public void playGame() throws IOException {
        Integer i = 0;
        while(i < 8) {
            playerMove("X");
            this.checkWinConditions();
            if(XWins) {
                printStream.println("Player X is the winner!");
                break;
            }
            playerMove("O");
            this.checkWinConditions();
            if(OWins) {
                printStream.println("Player O is the winner!");
                break;
            }
            i+=2;
        }
        if (!XWins && !OWins) {
            playerMove("X");
            this.checkWinConditions();
            if (XWins) {
                printStream.println("Player X is the winner!");
            } else {
                board.draw();
                printStream.println("Game is a draw.");
            }
        }
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

    public void checkWinConditions() {
        if (board.showSpacesOfBoard().get(0).equals(board.showSpacesOfBoard().get(1)) && board.showSpacesOfBoard().get(0).equals(board.showSpacesOfBoard().get(2))) {
            if (board.showSpacesOfBoard().get(0).equals("X")) {
                XWins= true;
            } else {
                OWins = true;
            }
        } else if (board.showSpacesOfBoard().get(3).equals(board.showSpacesOfBoard().get(4)) && board.showSpacesOfBoard().get(3).equals(board.showSpacesOfBoard().get(5))) {
            if (board.showSpacesOfBoard().get(3).equals("X")) {
                XWins = true;
            } else {
                OWins = true;
            }
        } else if (board.showSpacesOfBoard().get(6).equals(board.showSpacesOfBoard().get(7)) && board.showSpacesOfBoard().get(6).equals(board.showSpacesOfBoard().get(8))) {
            if (board.showSpacesOfBoard().get(6).equals("X")) {
                XWins = true;
            } else {
                OWins = true;
            }
        }
    }

}
