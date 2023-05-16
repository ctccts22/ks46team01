package ks46team01.user.board.Repository;

import ks46team01.user.board.entity.FreeBoard;
import ks46team01.user.board.entity.FreeBoardReply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreeBoardReplyRepository extends JpaRepository<FreeBoardReply, Long> {

    List<FreeBoardReply> findAllByFreeBoard(FreeBoard freeBoard);

    Page<FreeBoardReply> findByFreeBoard(FreeBoard freeBoard, Pageable pageable);

    List<FreeBoardReply> findByFreeBoardFreeBoardIdx(Long freeBoardIdx);

    void deleteAllByFreeBoard(FreeBoard freeBoard);

}
