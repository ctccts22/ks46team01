package ks46team01.user.board.Repository;

import ks46team01.user.board.entity.FreeBoard;
import ks46team01.user.board.entity.FreeBoardReply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreeBoardReplyRepository extends JpaRepository<FreeBoardReply, Long> {

    List<FreeBoardReply> findAllByFreeBoard(FreeBoard freeBoard);

    //    Page<FreeBoardReply> findByFreeBoard(FreeBoard freeBoard, Pageable pageable);
    @Query(value = "SELECT * FROM free_board_reply WHERE free_board_idx = ?1 ORDER BY free_board_reply_idx DESC LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<FreeBoardReply> findByFreeBoardNative(Long freeBoardIdx, int limit, int offset);



    List<FreeBoardReply> findByFreeBoardFreeBoardIdx(Long freeBoardIdx);

    void deleteAllByFreeBoard(FreeBoard freeBoard);

}
