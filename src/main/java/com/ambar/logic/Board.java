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
        board[1][0] = new Knight(Color.WHITE, new Square(1, 0));
        board[2][0] = new Bishop(Color.WHITE, new Square(2, 0));
        board[3][0] = new Queen(Color.WHITE, new Square(3, 0));
        board[4][0] = new King(Color.WHITE, new Square(4, 0));
        board[5][0] = new Bishop(Color.WHITE, new Square(5, 0));
        board[6][0] = new Knight(Color.WHITE, new Square(6, 0));
        board[7][0] = new Rook(Color.WHITE, new Square(7, 0));

        //black
        for(int i = 0; i < 8; i++)
        {
            board[i][6] = new Pawn(Color.BLACK, new Square(i, 6));
        }
        board[0][7] = new Rook(Color.BLACK, new Square(0, 7));
        board[1][7] = new Knight(Color.BLACK, new Square(1, 7));
        board[2][7] = new Bishop(Color.BLACK, new Square(2, 7));
        board[3][7] = new Queen(Color.BLACK, new Square(3, 7));
        board[4][7] = new King(Color.BLACK, new Square(4, 7));
        board[5][7] = new Bishop(Color.BLACK, new Square(5, 7));
        board[6][7] = new Knight(Color.BLACK, new Square(6, 7));
        board[7][7] = new Rook(Color.BLACK, new Square(7, 7));
    }

    public boolean checkMove(Square src, Square dest)
    {
        int srcX = src.getX();
        int srcY = src.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        Error err = Error.NO_ERROR;
        Piece p = board[srcX][srcY];

        if(p == null)
        {
            return false;
        }
        if (!p.move(this, dest))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void move(Square src, Square dest)
    {
        int srcX = src.getX();
        int srcY = src.getY();
        int destX = dest.getX();
        int destY = dest.getY();

        Piece p = board[srcX][srcY];

        board[srcX][srcY] = null;
        board[destX][destY] = p;
    }

    public void add(Piece p) {
        board [p.getSquare().getX()][p.getSquare().getY()] = p;
    }

    public Piece[] getAllPieces()
    {
        List<Piece> list = new ArrayList();
        for (int x = 0; x < BOARD_SIZE; x++)
        {
            for (int y = 0; y < BOARD_SIZE; y++)
            {
                Piece p = board[x][y];
                if(p != null)
                {
                    list.add(p);
                }
            }
        }
        return list.toArray(new Piece[] {});
    }
}