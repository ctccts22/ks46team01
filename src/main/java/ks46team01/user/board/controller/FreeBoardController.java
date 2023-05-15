package ks46team01.user.board.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.user.board.dto.FreeBoardDTO;
import ks46team01.user.board.entity.FreeBoard;
import ks46team01.user.board.service.FreeBoardService;
import ks46team01.user.info.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
        log.info("board:{}", freeBoard);
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
            RedirectAttributes redirectAttributes) {

        User user = (User) session.getAttribute("user");
        log.info("user: {}", user);

        if (user == null) {
            session.setAttribute("error", "error");
            return "redirect:/user/board/addFreeBoard";
        }

        FreeBoard newFreeBoard = freeBoardService.createFreeBoard(freeBoardTitle, freeBoardContent, user);

        if (newFreeBoard == null) {
            session.setAttribute("error", "error");
            return "redirect:/user/board/addFreeBoard";
        }
        session.setAttribute("success", "success");
        return "redirect:/user/freeBoard";
    }

    @PostMapping("/updateFreeBoard/{freeBoardIdx}")
    public ResponseEntity<?> editFreeBoard(@PathVariable("freeBoardIdx") Long freeBoardIdx,
                                           @RequestBody FreeBoard newPostData,
                                           HttpSession session) {

        Object loggedInUser = session.getAttribute("user");
        Object loggedInAdmin = session.getAttribute("adminUser");
        if (loggedInUser == null && loggedInAdmin == null) {
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        FreeBoard post = freeBoardService.getFreeBoardById(freeBoardIdx);
        if (post == null) {
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }
        if (loggedInUser != null && !post.getUsername().getUsername().equals(((User) loggedInUser).getUsername())) {
            return new ResponseEntity<>("You do not have permission to edit this post", HttpStatus.FORBIDDEN);
        }
        FreeBoard updatedPost = freeBoardService.updateFreeBoard(freeBoardIdx, newPostData);
        if (updatedPost == null) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Board Updated", HttpStatus.OK);
    }

    @PostMapping("/deleteFreeBoard/{freeBoardIdx}")
    public ResponseEntity<?> deleteFreeBoard(@PathVariable("freeBoardIdx") Long freeBoardIdx,
                                             HttpSession session) {

        Object loggedInUser = session.getAttribute("user");
        Object loggedInAdmin = session.getAttribute("adminUser");
        if (loggedInUser == null && loggedInAdmin == null) {
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        FreeBoard post = freeBoardService.getFreeBoardById(freeBoardIdx);
        if (post == null) {
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }
        if (loggedInUser != null && !post.getUsername().getUsername().equals(((User) loggedInUser).getUsername())) {
            return new ResponseEntity<>("You do not have permission to delete this post", HttpStatus.FORBIDDEN);
        }
        boolean deleteSuccess = freeBoardService.deleteFreeBoard(freeBoardIdx);
        if (!deleteSuccess) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Board Deleted", HttpStatus.OK);
    }
}
