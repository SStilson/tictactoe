package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private List<String> spaces;
    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        this.spaces = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));

    }

    public List<String> showSpacesOfBoard() {
        return spaces;
    }

    public void setSpacesOfBoard(List<String> spaces) {
        this.spaces = spaces;
    }

    public void draw() {
        printStream.println(spaces.get(0) + "|" + spaces.get(1) + "|" + spaces.get(2) + "\n_____\n" + spaces.get(3) + "|" + spaces.get(4) + "|" + spaces.get(5) + "\n_____\n"+ spaces.get(6) + "|" + spaces.get(7) + "|" + spaces.get(8));
    }
}
