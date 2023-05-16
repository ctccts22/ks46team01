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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/user")
public class FreeBoardReplyController {

    private final FreeBoardReplyService freeBoardReplyService;
    private final FreeBoardService freeBoardService;

    @PostMapping("/addFreeBoardReply")
    public String addFreeBoardReply(
            @RequestParam("freeBoardReplyContent") String freeBoardReplyContent,
            @RequestParam("freeBoardIdx") Long freeBoardIdx,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        User user = (User) session.getAttribute("user");
        log.info("user: {}", user);
        if (user == null) {
            session.setAttribute("error", "error");
            return "redirect:/user/freeBoardContent/" + freeBoardIdx;
        }
        FreeBoard freeBoard = freeBoardService.getFreeBoardById(freeBoardIdx);
        if (freeBoard == null) {
        }
        FreeBoardReply newFreeBoardReply = freeBoardReplyService.createFreeBoardReply(freeBoardReplyContent, user, freeBoard);
        if (newFreeBoardReply == null) {
            session.setAttribute("error", "error");
            return "redirect:/user/board/freeBoardContent/" + freeBoardIdx;
        }
        session.setAttribute("success", "success");
        return "redirect:/user/freeBoardContent/" + freeBoardIdx;
    }

    @PostMapping("/updateFreeBoardReply/{freeBoardReplyIdx}")
    public ResponseEntity<?> editFreeBoardReply(@PathVariable("freeBoardReplyIdx") Long freeBoardReplyIdx,
                                                @RequestBody FreeBoardReply updatedReplyData,
                                                HttpSession session) {

        Object loggedInUser = session.getAttribute("user");
        Object loggedInAdmin = session.getAttribute("adminUser");
        if (loggedInUser == null && loggedInAdmin == null) {
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        FreeBoardReply reply = freeBoardReplyService.getFreeBoardReplyById(freeBoardReplyIdx);
        if (reply == null) {
            return new ResponseEntity<>("Reply not found", HttpStatus.NOT_FOUND);
        }
        if (loggedInUser != null && !reply.getUsername().getUsername().equals(((User) loggedInUser).getUsername()) && loggedInAdmin == null) {
            return new ResponseEntity<>("You do not have permission to edit this reply", HttpStatus.FORBIDDEN);
        }
        FreeBoardReply updatedReply = freeBoardReplyService.updateFreeBoardReply(freeBoardReplyIdx, updatedReplyData);
        if (updatedReply == null) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Reply Updated", HttpStatus.OK);
    }


    @PostMapping("/deleteFreeBoardReply/{freeBoardReplyIdx}")
    public ResponseEntity<?> deleteFreeBoardReply(@PathVariable("freeBoardReplyIdx") Long freeBoardReplyIdx,
                                                  HttpSession session) {

        Object loggedInUser = session.getAttribute("user");
        Object loggedInAdmin = session.getAttribute("adminUser");
        if (loggedInUser == null && loggedInAdmin == null) {
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        FreeBoardReply reply = freeBoardReplyService.getFreeBoardReplyById(freeBoardReplyIdx);
        if (reply == null) {
            return new ResponseEntity<>("Reply not found", HttpStatus.NOT_FOUND);
        }
        if (loggedInUser != null && !reply.getUsername().getUsername().equals(((User) loggedInUser).getUsername()) && loggedInAdmin == null) {
            return new ResponseEntity<>("You do not have permission to delete this reply", HttpStatus.FORBIDDEN);
        }
        boolean deleteSuccess = freeBoardReplyService.deleteFreeBoardReply(freeBoardReplyIdx);
        if (!deleteSuccess) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Reply Deleted", HttpStatus.OK);
    }



}

