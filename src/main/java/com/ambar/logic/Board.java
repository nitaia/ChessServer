package com.ambar.logic;

import lombok.Getter;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    public static final int BOARD_SIZE = 8;
    @Getter
    private Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];

    public Board()
    {
        start();
    }

    public void start()
    {
        //white
        for(int i = 0; i < 8; i++)
        {
            board[i][1] = new Pawn(Color.WHITE, new Square(i, 1));
        }
        board[0][0] = new Rook(Color.WHITE, new Square(0, 0));
        board[0][1] = new Knight(Color.WHITE, new Square(0, 1));
        board[0][2] = new Bishop(Color.WHITE, new Square(0, 2));
        board[0][3] = new Queen(Color.WHITE, new Square(0, 3));
        board[0][4] = new King(Color.WHITE, new Square(0, 4));
        board[0][5] = new Bishop(Color.WHITE, new Square(0, 5));
        board[0][6] = new Knight(Color.WHITE, new Square(0, 6));
        board[0][7] = new Rook(Color.WHITE, new Square(0, 7));

        //black
        for(int i = 0; i < 8; i++)
        {
            board[i][6] = new Pawn(Color.BLACK, new Square(i, 1));
        }
        board[7][0] = new Rook(Color.BLACK, new Square(7, 0));
        board[7][1] = new Knight(Color.BLACK, new Square(7, 1));
        board[7][2] = new Bishop(Color.BLACK, new Square(7, 2));
        board[7][3] = new Queen(Color.BLACK, new Square(7, 3));
        board[7][4] = new King(Color.BLACK, new Square(7, 4));
        board[7][5] = new Bishop(Color.BLACK, new Square(7, 5));
        board[7][6] = new Knight(Color.BLACK, new Square(7, 6));
        board[7][7] = new Rook(Color.BLACK, new Square(7, 7));
    }

    public boolean move(Square src, Square dest)
    {
        int srcX = src.getX();
        int srcY = src.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        Piece p = board[srcX][srcY];
        if(board[srcX][srcY] == null)
        {
            return false;
        }
        if (!p.move(this, dest))
        {
            return false;
        }
        else
        {
            board[srcX][srcY] = null;
            board[destX][destY] = p;
            return true;
        }
    }


    public void add(Piece p) {
        board [p.getSquare().getX()][p.getSquare().getY()] = p;
    }

    public Piece[] getAllPieces() {
        List<Piece> list = new ArrayList();
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                Piece p = board[x][y];
                if(p != null) {
                    list.add(p);
                }
            }
        }
        return list.toArray(new Piece[] {});
    }
}