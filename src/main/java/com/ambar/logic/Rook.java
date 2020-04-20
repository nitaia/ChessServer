package com.ambar.logic;

public class Rook extends Piece {

    public Rook(Color color, Square square)
    {
        super("rook", color, square);
    }

    @Override
    public boolean move(Board board, Square dest) {
        boolean isok = false;
        int srcX = square.getX();
        int srcY = square.getX();
        int destX = dest.getX();
        int destY = dest.getY();
        Piece[][] brd = board.getBoard();

        if(srcX == destX && srcY != destY)
        {
            isok = true;
            for(int i = srcY < destY ? srcY : destY; i < (srcY > destY ? srcY : destY); i++)
            {
                if(board.getBoard()[srcX][i] != null)
                {
                    return false;
                }
            }
        }

        if(srcX != destX && srcY == destY)
        {
            isok = true;
            for(int i = srcX < destX ? srcX : destX; i < (srcX > destX ? srcX : destX); i++)
            {
                if(board.getBoard()[i][srcY] != null)
                {
                    return false;
                }
            }
        }

        if(brd[destX][destY] == null || (brd[destX][destY] != null && brd[destX][destY].color != color))
        {
            return false;
        }

        return isok;
    }
}
