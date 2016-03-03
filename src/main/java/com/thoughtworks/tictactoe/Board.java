package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private final List<String> spaces;
    private PrintStream printStream;
//    private ArrayList<ArrayList<Integer>> gameBoard;

    public Board(PrintStream printStream) {
        this.printStream = printStream;

/*        ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
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

        this.gameBoard = board;*/

        List<String> spaces = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        this.spaces = spaces;

    }

    public List<String> showSpacesOfBoard() {
        return spaces;
    }

    public void draw() {
        printStream.println(spaces.get(0) + "|" + spaces.get(1) + "|" + spaces.get(2) + "\n_____\n" + spaces.get(3) + "|" + spaces.get(4) + "|" + spaces.get(5) + "\n_____\n"+ spaces.get(6) + "|" + spaces.get(7) + "|" + spaces.get(8));
    }
}
