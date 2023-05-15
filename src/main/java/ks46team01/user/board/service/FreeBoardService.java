package ks46team01.user.board.service;

import ks46team01.user.board.Repository.FreeBoardReplyRepository;
import ks46team01.user.board.Repository.FreeBoardRepository;
import ks46team01.user.board.dto.FreeBoardDTO;
import ks46team01.user.board.entity.FreeBoard;
import ks46team01.user.board.entity.FreeBoardReply;
import ks46team01.user.info.entity.User;
import ks46team01.user.info.repository.UserRepository;
import ks46team01.user.info.service.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class FreeBoardService {
    private final UserRepository userRepository;
    private final FreeBoardRepository freeBoardRepository;
    private final FreeBoardReplyRepository freeBoardReplyRepository;


    public Page<FreeBoard> getAllList(Pageable pageable) {
        return freeBoardRepository.findAllWithPagination(pageable);
    }

    public FreeBoard getFreeBoardById(Long freeBoardIdx) {
        return freeBoardRepository.findById(freeBoardIdx)
                .orElseThrow(() -> new ResourceNotFoundException("FreeBoard not found with id " + freeBoardIdx));
    }

    public void increaseFreeBoardView(Long freeBoardIdx) {
        FreeBoard freeBoard = getFreeBoardById(freeBoardIdx);
        freeBoard.setFreeBoardView(freeBoard.getFreeBoardView() + 1);
        freeBoardRepository.save(freeBoard);
    }

    public FreeBoard createFreeBoard(String title, String content, User user) {
        try {
            FreeBoard freeBoard = new FreeBoard();
            freeBoard.setFreeBoardTitle(title);
            freeBoard.setFreeBoardContent(content);
            freeBoard.setUsername(user);
            freeBoard.setFreeBoardDate(LocalDateTime.now());
            freeBoard.setFreeBoardView(0);

            return freeBoardRepository.save(freeBoard);
        } catch (Exception e) {
            log.error("에러발생", e);
            return null;
        }
    }
    public FreeBoard updateFreeBoard(Long freeBoardIdx, FreeBoard newPostData) {
        try {
            FreeBoard freeBoard = getFreeBoardById(freeBoardIdx);

            if (freeBoard != null) {
                freeBoard.setFreeBoardTitle(newPostData.getFreeBoardTitle());
                freeBoard.setFreeBoardContent(newPostData.getFreeBoardContent());

                return freeBoardRepository.save(freeBoard);
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error("Error occurred", e);
            return null;
        }
    }


    public boolean deleteFreeBoard(Long freeBoardIdx) {
        try {
            freeBoardRepository.deleteById(freeBoardIdx);
            return true;
        } catch (Exception e) {
            log.error("Error occurred", e);
            return false;
        }
    }



}

