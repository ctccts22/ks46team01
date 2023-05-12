package ks46team01.user.board.Repository;

import ks46team01.user.board.entity.FreeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomFreeBoardRepository {
    Page<FreeBoard> findAllWithPagination(Pageable pageable);
}
