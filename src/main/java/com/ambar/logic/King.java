package com.ambar.logic;

public class King extends Piece {

    public King(Color color, Square square)
    {
        super("king", color, square);
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

        if(destX == srcX && destY == srcY + 1)
        {
            return true;
        }
        else if(destX == srcX + 1 && destY == srcY + 1)
        {
            return true;
        }
        else if(destX == srcX + 1 && destY == srcY)
        {
            return true;
        }
        else if(destX == srcX + 1 && destY == srcY - 1)
        {
            return true;
        }
        else if(destX == srcX && destY == srcY - 1)
        {
            return true;
        }
        else if(destX == srcX - 1 && destY == srcY - 1)
        {
            return true;
        }
        else if(destX == srcX - 1 && destY == srcY)
        {
            return true;
        }
        else if(destX == srcX - 1 && destY == srcY + 1)
        {
            return true;
        }
        return false;
    }
}
