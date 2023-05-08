package ks46team01.user.board.Repository;

import ks46team01.user.board.entity.FreeBoardReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreeBoardReplyRepository extends JpaRepository<FreeBoardReply, Long> {

}
