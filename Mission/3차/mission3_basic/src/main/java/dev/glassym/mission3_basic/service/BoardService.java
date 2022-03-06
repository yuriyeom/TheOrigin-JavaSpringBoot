package dev.glassym.mission3_basic.service;

import dev.glassym.mission3_basic.entity.BoardEntity;
import dev.glassym.mission3_basic.model.BoardDto;
import dev.glassym.mission3_basic.repository.BoardDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
    private final BoardDao boardDao;

    public BoardService(
            @Autowired BoardDao boardDao
    ){
        this.boardDao = boardDao;
    }

    public void createBoard(BoardDto dto){
        this.boardDao.createBoard(dto);
    }

    public BoardDto readBoard(int id){

        BoardEntity boardEntity = this.boardDao.readBoard(id);
        return new BoardDto(
                boardEntity.getId(),
                boardEntity.getName());
    }

    public List<BoardDto> readBoardAll(){
        Iterator<BoardEntity> iterator = this.boardDao.readBoardAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        while(iterator.hasNext()){
            BoardEntity boardEntity = iterator.next();
            boardDtoList.add(new BoardDto(
                    boardEntity.getId(),
                    boardEntity.getName()
            ));
        }
        return boardDtoList;
    }

    public void updateBoard(int id, BoardDto dto){
        this.boardDao.updateBoard(id, dto);
    }

    public void deleteBoard(int id){
        this.boardDao.deleteBoard(id);
    }
}
