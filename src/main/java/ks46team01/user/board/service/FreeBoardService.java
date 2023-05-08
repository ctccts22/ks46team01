package ks46team01.user.board.service;

import ks46team01.user.board.Repository.FreeBoardReplyRepository;
import ks46team01.user.board.Repository.FreeBoardRepository;
import ks46team01.user.board.entity.FreeBoard;
import ks46team01.user.board.entity.FreeBoardReply;
import ks46team01.user.info.service.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@AllArgsConstructor
public class FreeBoardService {
    private final FreeBoardRepository freeBoardRepository;
    private final FreeBoardReplyRepository freeBoardReplyRepository;


    public Page<FreeBoard> getAllList(Pageable pageable) {
        return freeBoardRepository.findAllWithPagination(pageable);
    }

    public FreeBoard getFreeBoardById(Long freeBoardIdx) {
        return freeBoardRepository.findById(freeBoardIdx)
                .orElseThrow(() -> new ResourceNotFoundException("FreeBoard not found with id " + freeBoardIdx));
    }

}

