package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

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
    private Board mockBoard;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = new Board(printStream);
        game = new Game(board, reader, printStream);
        mockBoard = mock(Board.class);
    }

    @Test
    public void gameShouldRespondToPlayerOneMove() throws IOException {
        when(reader.readLine()).thenReturn("1");

        game.playerMove("X");

        assertThat(board.showSpacesOfBoard().get(0), is("X"));

    }

    @Test
    public void gameShouldRespondToPlayerTwoMove() throws IOException {
        when(reader.readLine()).thenReturn("1");

        game.playerMove("O");

        assertThat(board.showSpacesOfBoard().get(0), is("O"));

    }

    @Test
    public void shouldNotAllowPlayersToMoveIntoTakenSpace() throws IOException {
        when(mockBoard.showSpacesOfBoard()).thenReturn(new ArrayList<String>(Arrays.asList("X","O","X","O","X","O","X","O","X")));
        when(reader.readLine()).thenReturn("1");

        game.playerMove("X");

        verify(printStream).println(contains("Location already taken!"));
    }

    @Test
    public void shouldFillBoardWhenThereAreNoWinners() throws IOException {
        when(mockBoard.showSpacesOfBoard()).thenReturn(new ArrayList<String>(Arrays.asList("1","O","X","O","X","O","X","O","X")));
        when(reader.readLine()).thenReturn("1");

        game.playGame();

        verify(printStream).println(contains("Game is a draw."));
    }

    @Test
    public void gameShouldEndWhenOnePlayerHasThreeInARow() throws IOException {
        when(mockBoard.showSpacesOfBoard()).thenReturn(new ArrayList<String>(Arrays.asList("1","X","X","O","X","O","X","O","X")));
        when(reader.readLine()).thenReturn("1");

        game.playGame();

        verify(printStream).println(contains("Player X is the winner!"));
    }

}