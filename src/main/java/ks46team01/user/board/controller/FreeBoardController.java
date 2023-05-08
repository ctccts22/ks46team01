package ks46team01.user.board.controller;

import ks46team01.user.board.entity.FreeBoard;
import ks46team01.user.board.service.FreeBoardService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class FreeBoardController {

    private final FreeBoardService freeBoardService;

    @GetMapping("/freeBoard")
    public String showFreeBoardForm(Model model, @RequestParam(required = false, defaultValue = "0") int page) {
        PageRequest pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "freeBoardIdx"));
        Page<FreeBoard> boards = freeBoardService.getAllList(pageable);
        model.addAttribute("title", "자유게시판");
        model.addAttribute("page", boards);
        model.addAttribute("pageable", pageable);
        return "user/freeBoard";
    }

    @GetMapping("/freeBoardContent/{freeBoardIdx}")
    public String getFreeBoardContent(@PathVariable("freeBoardIdx") Long freeBoardIdx, Model model) {
        FreeBoard freeBoard = freeBoardService.getFreeBoardById(freeBoardIdx);
        model.addAttribute("board", freeBoard);
        return "user/freeBoardContent";
    }
}
