package com.thoughtworks.tictactoe;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    @Test
    public void shouldDisplayBoardWhenDrawing() {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);

        board.draw();

        verify(printStream).println(contains("9"));
    }

}