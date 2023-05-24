package ks46team01.user.board.Repository;

import ks46team01.user.board.entity.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long>, CustomFreeBoardRepository{

}
