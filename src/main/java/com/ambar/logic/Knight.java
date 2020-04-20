package com.ambar.logic;

public class Knight extends Piece {

    public Knight(Color color, Square square)
    {
        super("knight", color, square);
    }

    @Override
    public boolean move(Board board, Square dest) {
        int srcX = square.getX();
        int srcY = square.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        Piece[][] brd = board.getBoard();

        if(brd[destX][destY] != null && brd[destX][destY].color == color)
        {
            return false;
        }

        if(destX == srcX + 1 && destY == srcY + 2)
        {
            return true;
        }
        else if(destX == srcX + 2 && destY == srcY + 1)
        {
            return true;
        }
        else if(destX == srcX - 1 && destY == srcY + 2)
        {
            return true;
        }
        else if(destX == srcX - 2 && destY == srcY + 1)
        {
            return true;
        }
        else if(destX == srcX - 1 && destY == srcY - 2)
        {
            return true;
        }
        else if(destX == srcX - 2 && destY == srcY - 1)
        {
            return true;
        }
        else if(destX == srcX + 2 && destY == srcY - 1)
        {
            return true;
        }
        else if(destX == srcX + 1 && destY == srcY - 2)
        {
            return true;
        }
        return false;
    }
}
