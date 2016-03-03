package com.thoughtworks.tictactoe;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class GameTest {

    @Test
    public void gameShouldRespondToPlayerOneMove() {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        Game game = new Game(board);

        //game.playerOneMove();


    }

}