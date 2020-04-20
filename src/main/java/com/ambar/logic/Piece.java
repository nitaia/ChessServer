package com.ambar.logic;

import lombok.Getter;
import lombok.Setter;

public abstract class Piece {
    @Getter
    @Setter
    protected Square square;
    @Getter
    protected String name;
    @Getter
    protected Color color = Color.WHITE;

    public Piece(String name, Color color, Square square)
    {
        this.name = name;
        this.color = color;
        this.square = square;
    }

    public abstract boolean move(Board board, Square dest);
}
