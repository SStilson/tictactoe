package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private PrintStream printStream;
    private ArrayList<ArrayList<Integer>> gameBoard;

    public Board(PrintStream printStream) {
        this.printStream = printStream;

        ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> rowOne = new ArrayList<Integer>();
        rowOne.add(1);
        rowOne.add(2);
        rowOne.add(3);
        board.add(rowOne);

        ArrayList<Integer> rowTwo = new ArrayList<Integer>();
        rowOne.add(4);
        rowOne.add(5);
        rowOne.add(6);
        board.add(rowTwo);

        ArrayList<Integer> rowThree = new ArrayList<Integer>();
        rowOne.add(7);
        rowOne.add(8);
        rowOne.add(9);
        board.add(rowThree);

        this.gameBoard = board;

    }

    public void draw() {
        printStream.println("1|2|3\n_____\n4|5|6\n_____\n7|8|9");
//        for (int j = 0; j < 10; j++) {
//            for (int i = 0; i < gameBoard.size(); i++) {
//                printStream.print(gameBoard.get(j).get(i));
//                if (gameBoard.get(j).get(i) % 3 == 0) {
//                    printStream.print("\n_____\n");
//                } else if (gameBoard.get(j).get(i) == gameBoard.size() - 1) {
//                    break;
//                } else printStream.print("|");
//            }
//        }
    }
}
