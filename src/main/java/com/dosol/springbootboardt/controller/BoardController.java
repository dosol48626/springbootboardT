package com.dosol.springbootboardt.controller;

import com.dosol.springbootboardt.dto.BoardDTO;
import com.dosol.springbootboardt.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2

@RequestMapping("/board")
public class BoardController {
    @Autowired
    //final 쓰고 싶으면 리콰이어드 아그 컨스트럭트 해줘야함. @Log밑에
    private BoardService boardService;

    @GetMapping("/list")
    public void list(Model model) {
        //근데 여기서 Model이 뭐지??
        log.info("list");
        model.addAttribute("boardList", boardService.getList());
    }

    @GetMapping("/register")
    public void registerGet() {
        log.info("registerGet");
    }

    @PostMapping("/register")
    public String register(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
        boardService.register(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(@RequestParam("bno") int bno, Model model) {
        BoardDTO boardDTO = boardService.getOne(bno);
        model.addAttribute("boardDTO", boardDTO);
    }

    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
        boardService.modify(boardDTO);
        return "redirect:/board/read";
    }

    @GetMapping ("/remove")
    public String remove(@RequestParam("bno") int bno, RedirectAttributes redirectAttributes) {
        boardService.remove(bno);
        return "redirect:/board/list";
    }
}
