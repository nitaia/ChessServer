package com.ambar.logic;

public class Pawn extends Piece {

    public Pawn(Color color, Square square)
    {
        super("pawn", color, square);
    }

    @Override
    public boolean move(Board board, Square dest) {
        int srcX = square.getX();
        int srcY = square.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        Piece[][] brd = board.getBoard();

        if(color == Color.WHITE)
        {
            if(srcX == 1)
            {
                if(destX == srcX && destY == srcY + 2)
                {
                    if(brd[destX][destY] == null)
                    {
                        return true;
                    }
                }
            }

            if(destX == srcX && destY == srcY + 1)
            {
                if(brd[destX][destY] == null)
                {
                    return true;
                }
            }

            if(destY == srcY + 1 && (destX == srcX + 1 || destX == srcX - 1))
            {
                if(brd[destX][destY] != null && brd[destX][destY].color == color)
                {
                    return true;
                }
            }

            return false;
        }
        else
        {
            if(srcX == 6)
            {
                if(destX == srcX && destY == srcY - 2)
                {
                    if(brd[destX][destY] == null)
                    {
                        return true;
                    }
                }
            }

            if(destX == srcX && destY == srcY - 1)
            {
                if(brd[destX][destY] == null)
                {
                    return true;
                }
            }

            if(destY == srcY - 1&& (destX == srcX + 1 || destX == srcX - 1))
            {
                if(brd[destX][destY] != null && brd[destX][destY].color == color)
                {
                    return true;
                }
            }

            return false;
        }
    }
}
