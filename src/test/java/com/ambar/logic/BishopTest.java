package com.ambar.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BishopTest {

    @Test
    public void testCleanMoveUp() {
        Board board = new Board();
        Bishop b = new Bishop(Color.WHITE, new Square(2, 2));
        board.add(b);
        assertTrue(b.move(board, new Square(4, 4)));
    }

    @Test
    public void testCleanMoveDown() {
        Board board = new Board();
        Bishop b = new Bishop(Color.WHITE, new Square(5, 5));
        board.add(b);
        assertTrue(b.move(board, new Square(7, 3)));
    }

    @Test
    public void testMoveToCurrenPlace() {
        Board board = new Board();
        Bishop b = new Bishop(Color.WHITE, new Square(2, 2));
        board.add(b);
        assertFalse(b.move(board, new Square(2, 2)));
    }

    @Test
    public void testInvalidMove() {
        Board board = new Board();
        Bishop b = new Bishop(Color.WHITE, new Square(2, 2));
        board.add(b);
        assertFalse(b.move(board, new Square(4, 5)));
    }

    @Test
    public void testPieceInPath() {
        Board board = new Board();
        Bishop b = new Bishop(Color.WHITE, new Square(2, 2));
        Pawn p = new Pawn(Color.WHITE, new Square(4, 4));
        board.add(b);
        board.add(p);
        assertFalse(b.move(board, new Square(6, 6)));
    }

    @Test
    public void testPieceWithSameColorInDest() {
        Board board = new Board();
        Bishop b = new Bishop(Color.WHITE, new Square(2, 2));
        Pawn p = new Pawn(Color.WHITE, new Square(6, 6));
        p.color = Color.BLACK;
        b.color = Color.BLACK;
        board.add(b);
        board.add(p);
        assertFalse(b.move(board, new Square(6, 6)));
    }

    @Test
    public void testPieceWithDiffColorInDest() {
        Board board = new Board();
        Bishop b = new Bishop(Color.WHITE, new Square(2, 2));
        Pawn p = new Pawn(Color.WHITE, new Square(6, 6));
        p.square = new Square(6, 6);
        b.square = new Square(2, 2);
        board.add(b);
        board.add(p);
        assertTrue(b.move(board, new Square(6, 6)));
    }
}
