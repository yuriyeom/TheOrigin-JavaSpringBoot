package dev.glassym.mission2_basic.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board")
public class BoardRestController {
    private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
    private final BoardService boardService;

    public BoardRestController(
            @Autowired BoardService boardService
    ){
        this.boardService = boardService;
    }

    @PostMapping()
    public void createBoard(@RequestBody BoardDto boardDto){
        this.boardService.createBoard(boardDto);
    }

    @GetMapping()
    public List<BoardDto> readBoardAll(){
        return this.boardService.readBoardAll();
    }

    @GetMapping("{id}")
    public BoardDto readBoard(@PathVariable int id){
        return this.boardService.readBoard(id);
    }

    @PutMapping("{id}")
    public void updateBoard(
            @PathVariable int id,
            @RequestBody BoardDto boardDto
    ){
        this.boardService.updateBoard(id, boardDto);
    }

    @DeleteMapping("{id}")
    public void deleteBoard(@PathVariable int id){
        this.boardService.deleteBoard(id);
    }
}
