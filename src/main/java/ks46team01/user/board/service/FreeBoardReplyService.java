package ks46team01.user.board.service;

import ks46team01.user.board.Repository.FreeBoardReplyRepository;
import ks46team01.user.board.entity.FreeBoardReply;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class FreeBoardReplyService {

    private final FreeBoardReplyRepository freeBoardReplyRepository;

    public FreeBoardReplyService(FreeBoardReplyRepository freeBoardReplyRepository) {
        this.freeBoardReplyRepository = freeBoardReplyRepository;
    }

    // Create a new reply
    public FreeBoardReply addReply(FreeBoardReply reply) {
        return freeBoardReplyRepository.save(reply);
    }

    // Get all replies of a post
    public List<FreeBoardReply> getRepliesByPostId(Long freeBoardIdx) {
        return freeBoardReplyRepository.findAllByFreeBoard_FreeBoardIdx(freeBoardIdx);
    }

    // More methods as needed (delete, update, etc.)
}
