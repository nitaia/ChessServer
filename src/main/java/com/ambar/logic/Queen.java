package com.ambar.logic;

public class Queen extends Piece {

    public Queen(Color color, Square square)
    {
        super("queen", color, square);
    }

    @Override
    public boolean move(Board board, Square dest) {
        int srcX = square.getX();
        int srcY = square.getX();
        int destX = dest.getX();
        int destY = dest.getY();
        Piece[][] brd = board.getBoard();
        if(srcX == destX || srcY == destY)
        {
            return false;
        }
        int dirX = srcX < destX ? 1 : -1;
        int dirY = srcY < destY ? 1 : -1;

        if(srcX == destX && srcY != destY)
        {
            for(int i = srcY < destY ? srcY : destY; i < (srcY > destY ? srcY : destY); i++)
            {
                if(board.getBoard()[srcX][i] != null)
                {
                    return false;
                }
            }
            return true;
        }

        if(srcX != destX && srcY == destY)
        {
            for(int i = srcX < destX ? srcX : destX; i < (srcX > destX ? srcX : destX); i++)
            {
                if(board.getBoard()[i][srcY] != null)
                {
                    return false;
                }
            }
            return true;
        }

        int i = 0;
        while (true)
        {
            if(srcX + i*dirX == destX && srcY + i*dirY == destY)
            {
                break;
            }
            if((i == destX && i != destY) || (i != destX && i == destY))
            {
                return false;
            }
            if(brd[srcX + i*dirX][srcY + i*dirY] != null && i > 0)
            {
                return false;
            }
            i++;
        }

        if(brd[destX][destY] == null || (brd[destX][destY] != null && brd[destX][destY].color != color))
        {
            return true;
        }

        return false;
    }
}
