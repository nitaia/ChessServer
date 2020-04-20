package com.ambar.chess;

import com.ambar.logic.Board;
import com.ambar.logic.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChessController {

    Board board = new Board();

    @RequestMapping("/test1")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/board")
    public ResponseEntity<Piece[]> getBoard() {
        return new ResponseEntity<Piece[]>(board.getAllPieces(), HttpStatus.OK);
    }

}
