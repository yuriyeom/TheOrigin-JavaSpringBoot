package dev.glassym.mission2_basic.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardInMemoryRepository implements BoardRepository{

    private final List<BoardDto> boardList;

    public BoardInMemoryRepository(){
        this.boardList = new ArrayList<>();
    }

    @Override
    public boolean save(BoardDto boardDto) {
        return this.boardList.add(boardDto);
    }

    @Override
    public List<BoardDto> findAll() {
        return this.boardList;
    }

    @Override
    public BoardDto findById(int id) {
        return this.boardList.get(id);
    }

    @Override
    public boolean update(int id, BoardDto boardDto) {
        BoardDto targetBoard = this.boardList.get(id);

        if(boardDto.getName() != null){
            targetBoard.setName(boardDto.getName());
        }

        this.boardList.set(id, targetBoard);
        return true;
    }

    @Override
    public boolean delete(int id) {
        this.boardList.remove(id);
        return true;
    }
}
