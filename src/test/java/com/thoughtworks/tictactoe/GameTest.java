package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {

    private Game game;
    private Board board;
    private BufferedReader reader;
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = new Board(printStream);
        game = new Game(board, reader);
    }

    @Test
    public void gameShouldRespondToPlayerOneMove() throws IOException {

        when(reader.readLine()).thenReturn("1");


        game.playerOneMove();

        assertThat(board.showSpacesOfBoard().get(0), is("X"));

    }

    @Test
    public void gameShouldRespondToPlayerTwoMove() throws IOException {
        PrintStream printStream = mock(PrintStream.class);
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("1");
        Board board = new Board(printStream);
        Game game = new Game(board, reader);

        game.playerTwoMove();

        assertThat(board.showSpacesOfBoard().get(0), is("O"));

    }

}