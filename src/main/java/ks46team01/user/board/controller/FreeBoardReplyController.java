package ks46team01.user.board.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.user.board.entity.FreeBoard;
import ks46team01.user.board.entity.FreeBoardReply;
import ks46team01.user.board.service.FreeBoardReplyService;
import ks46team01.user.board.service.FreeBoardService;
import ks46team01.user.info.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/user")
public class FreeBoardReplyController {

    private final FreeBoardReplyService freeBoardReplyService;
    private final FreeBoardService freeBoardService;

    @PostMapping("/freeBoard/{freeBoardIdx}/addReply")
    public ResponseEntity<?> addReply(@PathVariable Long freeBoardIdx,
                                      @RequestBody FreeBoardReply reply,
                                      HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        reply.setUsername(user);
        FreeBoard post = freeBoardService.getFreeBoardById(freeBoardIdx);
        if (post == null) {
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }
        reply.setFreeBoard(post);
        FreeBoardReply savedReply = freeBoardReplyService.addReply(reply);
        return new ResponseEntity<>(savedReply, HttpStatus.CREATED);
    }

    @GetMapping("/freeBoard/{freeBoardIdx}/replies")
    public ResponseEntity<?> getReplies(@PathVariable Long freeBoardIdx, Model model) {
        List<FreeBoardReply> replies = freeBoardReplyService.getRepliesByPostId(freeBoardIdx);
        model.addAttribute("replies", replies);
        return new ResponseEntity<>(replies, HttpStatus.OK);
    }

}
