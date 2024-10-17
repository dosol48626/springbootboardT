package com.dosol.springbootboardt.mapper;

import com.dosol.springbootboardt.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
//내가 매퍼입니다. 하는 그런 어노테이션임
public interface BoardMapper {
    List<BoardDTO> selectAll();
    void insert(BoardDTO boardDTO);
    BoardDTO selectOne(int bno);
    void update(BoardDTO boardDTO);
    void delete(int bno);
    void visitCountUpdate(int bno);
}
