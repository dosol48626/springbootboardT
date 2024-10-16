package com.dosol.springbootboardt.service;

import com.dosol.springbootboardt.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> getList();
    void register(BoardDTO boardDTO);
    BoardDTO getOne(int bno);
    void modify(BoardDTO boardDTO);
    void remove(int bno);
}
