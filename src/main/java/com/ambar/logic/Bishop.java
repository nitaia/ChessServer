package com.ambar.logic;

public class Bishop extends Piece {

    public Bishop(Color color, Square square)
    {
        super("bishop", color, square);
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
