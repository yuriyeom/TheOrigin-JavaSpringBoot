package dev.glassym.mission3_basic.controller;

import dev.glassym.mission3_basic.model.BoardDto;
import dev.glassym.mission3_basic.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardService boardService;

    public BoardController(
            @Autowired BoardService boardService
    ){
        this.boardService = boardService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createBoard(
            @RequestBody BoardDto dto
    ){
        this.boardService.createBoard(dto);
    }

    @GetMapping("{id}")
    public BoardDto readBoard(
            @PathVariable("id") int id
    ){
        return this.boardService.readBoard(id);
    }

    @GetMapping()
    public List<BoardDto> readBoardAll(){
        return this.boardService.readBoardAll();
    }

    @PutMapping("{id}")
    public void updateBoard(
            @PathVariable("id") int id,
            @RequestBody BoardDto dto
    ){
        this.boardService.updateBoard(id, dto);
    }

    @DeleteMapping("{id}")
    public void deleteBoard(
            @PathVariable("id") int id
    ){
        this.boardService.deleteBoard(id);
    }

}
