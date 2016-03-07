package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {

    private Board board;
    private BufferedReader reader;
    private Player player1;
    private Player player2;
    private Game game;
    private PrintStream printStream;

    @Before
    public void setUp() {
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);

        game = new Game(board, reader, printStream, player1, player2);
    }

    @Test
    public void shouldDrawBoardWhenGameIsPlaying() throws IOException {
        game.playGame();

        verify(board).draw();
    }

    @Test
    public void playerOneShouldToMoveWhenPlaying() throws IOException {
        when(reader.readLine()).thenReturn("1");

        game.playGame();

        verify(player1).move();
    }

    @Test
    public void playerTwoShouldMoveWhenPlaying() throws IOException {
        when(reader.readLine()).thenReturn("1");

        game.playGame();

        verify(player2).move();
    }



}