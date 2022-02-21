package dev.glassym.mission2_basic.board;

import java.util.List;

public interface BoardRepository {
    boolean save(BoardDto boardDto);
    List<BoardDto> findAll();
    BoardDto findById(int id);
    boolean update(int id, BoardDto boardDto);
    boolean delete(int id);
}
