package dev.glassym.mission2_basic.board;

import dev.glassym.mission2_basic.post.PostDto;

import java.util.List;

public interface BoardService {
    void createBoard(BoardDto boardDto);
    List<BoardDto> readBoardAll();
    BoardDto readBoard(int id);
    void updateBoard(int id, BoardDto boardDto);
    void deleteBoard(int id);
}
