package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private List<String> locations;
    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        //TODO: Inject locations as a dependency
        this.locations = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
    }

    public List<String> showLocationsOnBoard() {
        return locations;
    }

    public void setLocationsOnBoard(List<String> spaces) {
        this.locations = spaces;
    }

    public void draw() {
        printStream.println(locations.get(0) + "|" + locations.get(1) + "|" + locations.get(2) + "\n_____\n" + locations.get(3) + "|" + locations.get(4) + "|" + locations.get(5) + "\n_____\n"+ locations.get(6) + "|" + locations.get(7) + "|" + locations.get(8));
    }

    public Boolean checkWinConditions() {
        for (int i = 0; i < locations.size()-3; i+=3) {
            if(locations.get(i).equals(locations.get(i+1)) && locations.get(i).equals(locations.get(i+2))) {
                return true;
            }
        } return false;
    }
}
