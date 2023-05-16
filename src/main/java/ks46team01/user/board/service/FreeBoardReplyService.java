package ks46team01.user.board.service;

import ks46team01.user.board.Repository.FreeBoardReplyRepository;
import ks46team01.user.board.Repository.FreeBoardRepository;
import ks46team01.user.board.entity.FreeBoard;
import ks46team01.user.board.entity.FreeBoardReply;
import ks46team01.user.info.entity.User;
import ks46team01.user.info.repository.UserRepository;
import ks46team01.user.info.service.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class FreeBoardReplyService {
    private final UserRepository userRepository;
    private final FreeBoardRepository freeBoardRepository;
    private final FreeBoardReplyRepository freeBoardReplyRepository;

    public FreeBoardReply createFreeBoardReply(String content, User user, FreeBoard freeBoard) {
        try {
            FreeBoardReply freeBoardReply = new FreeBoardReply();
            freeBoardReply.setFreeBoardReplyContent(content);
            freeBoardReply.setUsername(user);
            freeBoardReply.setFreeBoard(freeBoard);
            freeBoardReply.setFreeBoardReplyDate(LocalDateTime.now());

            return freeBoardReplyRepository.save(freeBoardReply);
        } catch (Exception e) {
            log.error("Error occurred", e);
            return null;
        }
    }

    public FreeBoardReply getFreeBoardReplyById(Long freeBoardReplyIdx) {
            return freeBoardReplyRepository.findById(freeBoardReplyIdx)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("freeBoardReplyIdx not found with id " + freeBoardReplyIdx));
        }


    public FreeBoardReply updateFreeBoardReply(Long freeBoardReplyIdx, FreeBoardReply updatedReplyData) {
        try {
            FreeBoardReply freeBoardReply = getFreeBoardReplyById(freeBoardReplyIdx);

            if (freeBoardReply != null) {
                freeBoardReply.setFreeBoardReplyContent(updatedReplyData.getFreeBoardReplyContent());
                return freeBoardReplyRepository.save(freeBoardReply);
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error("Error occurred", e);
            return null;
        }
    }

    public boolean deleteFreeBoardReply(Long freeBoardReplyIdx) {
        try {
            freeBoardReplyRepository.deleteById(freeBoardReplyIdx);
            return true;
        } catch (Exception e) {
            log.error("Error occurred", e);
            return false;
        }
    }

}
