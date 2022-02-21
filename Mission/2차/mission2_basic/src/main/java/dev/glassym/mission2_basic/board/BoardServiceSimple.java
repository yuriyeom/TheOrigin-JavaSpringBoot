package dev.glassym.mission2_basic.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceSimple implements BoardService{
    private static final Logger logger = LoggerFactory.getLogger(BoardServiceSimple.class);

    private final BoardRepository boardRepository;

    public BoardServiceSimple(
            @Autowired BoardRepository boardRepository
    ){
        this.boardRepository = boardRepository;
    }

    @Override
    public void createBoard(BoardDto boardDto) {
        this.boardRepository.save(boardDto);
    }

    @Override
    public List<BoardDto> readBoardAll() {
        return this.boardRepository.findAll();
    }

    @Override
    public BoardDto readBoard(int id) {
        return this.boardRepository.findById(id);
    }

    @Override
    public void updateBoard(int id, BoardDto boardDto) {
        this.boardRepository.update(id, boardDto);
    }

    @Override
    public void deleteBoard(int id) {
        this.boardRepository.delete(id);
    }
}
