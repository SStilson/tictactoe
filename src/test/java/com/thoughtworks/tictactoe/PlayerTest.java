package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private PrintStream printStream;
    private BufferedReader reader;
    private Board board;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);

        player1 = new Player(board, printStream, reader, "X");
        player2 = new Player(board, printStream, reader, "O");
    }

    @Test
    public void shouldPromptPlayerWhenMoving() throws IOException {
        when(board.showLocationsOnBoard()).thenReturn(new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9")));
        when(reader.readLine()).thenReturn("1");

        player1.move();

        verify(printStream).println("Please enter your move: ");
    }

    @Test
    public void shouldPlacePlayer1MoveInTopLeftWhenPlayer1EntersOne() throws IOException {
        when(board.showLocationsOnBoard()).thenReturn(new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9")));
        when(reader.readLine()).thenReturn("1");

        player1.move();

        assertThat(board.showLocationsOnBoard().get(0), is("X"));

    }

    @Test
    public void shouldPlacePlayer2MoveInTopLeftWhenPlayer2EntersOne() throws IOException {
        when(board.showLocationsOnBoard()).thenReturn(new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9")));
        when(reader.readLine()).thenReturn("1");

        player2.move();

        assertThat(board.showLocationsOnBoard().get(0), is("O"));
    }

    @Test
    public void shouldNotAllowPlayersToMoveIntoTakenSpace() throws IOException {
        when(board.showLocationsOnBoard()).thenReturn(new ArrayList<String>(Arrays.asList("X","2","X","O","X","O","X","O","X")));
        when(reader.readLine()).thenReturn("1", "2");

        player1.move();

        verify(printStream).println(contains("Location already taken!"));
    }

    /*// Test runs infinitely - TODO next
    @Test
    public void shouldFillBoardWhenThereAreNoWinners() throws IOException {
        when(mockBoard.showLocationsOnBoard()).thenReturn(new ArrayList<String>(Arrays.asList("1","O","X","O","X","O","X","O","X")));
        when(reader.readLine()).thenReturn("1");

        game.playGame();

        verify(printStream).println(contains("Game is a draw."));
    }*/

//   TODO: Replace
    // Test runs infinitely
    /*@Test
    public void shouldSayPlayerHasWonWhenRowIsFilled() throws IOException {
        when(mockBoard.checkWinConditions()).thenReturn(true);
        when(reader.readLine()).thenReturn("1");

        game.playGame();

        verify(printStream).println(contains("Player X is the winner!"));
    }*/


}