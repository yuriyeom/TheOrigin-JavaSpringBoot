package dev.glassym.mybatis.mapper;

import dev.glassym.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
