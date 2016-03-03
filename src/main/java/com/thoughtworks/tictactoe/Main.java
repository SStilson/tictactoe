package com.thoughtworks.tictactoe;


import java.io.PrintStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;

        Board board = new Board(printStream);

        board.draw();


    }
}
