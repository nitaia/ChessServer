package com.ambar.chess;

import com.ambar.logic.Board;
import com.ambar.logic.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ChessController {

    Board board = new Board();

    @RequestMapping("/board")
    public ResponseEntity<Piece[]> getBoard() {
        return new ResponseEntity<>(board.getAllPieces(), HttpStatus.OK);
    }

}
