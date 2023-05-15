package ks46team01.user.board.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.user.board.Repository.FreeBoardRepository;
import ks46team01.user.board.entity.FreeBoard;
import ks46team01.user.board.service.FreeBoardService;
import ks46team01.user.info.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;


@Controller
@Slf4j
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
        return "user/board/freeBoard";
    }

    @GetMapping("/freeBoardContent/{freeBoardIdx}")
    public String getFreeBoardContent(@PathVariable("freeBoardIdx") Long freeBoardIdx, Model model) {
        freeBoardService.increaseFreeBoardView(freeBoardIdx);
        FreeBoard freeBoard = freeBoardService.getFreeBoardById(freeBoardIdx);
        model.addAttribute("board", freeBoard);
        return "user/board/freeBoardContent";
    }

    @GetMapping("/addFreeBoard")
    public String showAddFreeBoardForm(Model model) {
        model.addAttribute("freeBoard", new FreeBoard());
        return "user/board/addFreeBoard";
    }

    @PostMapping("/addFreeBoard")
    public String addFreeBoard(
            @RequestParam("freeBoardTitle") String freeBoardTitle,
            @RequestParam("freeBoardContent") String freeBoardContent,
            HttpSession session,
            Model model) {

        User user = (User) session.getAttribute("user");
        log.info("user: {}", user);

        if (user == null) {
            model.addAttribute("errorMessage", "로그인 하십시오");
            return "user/board/addFreeBoard";
        }

        FreeBoard newFreeBoard = freeBoardService.createFreeBoard(freeBoardTitle, freeBoardContent, user);

        if (newFreeBoard == null) {
            model.addAttribute("errorMessage", "등록실패");
            return "user/board/addFreeBoard";
        }

        return "redirect:/user/freeBoard";
    }

}
