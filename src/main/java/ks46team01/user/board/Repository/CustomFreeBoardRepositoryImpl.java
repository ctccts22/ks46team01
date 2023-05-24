package ks46team01.user.board.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ks46team01.user.board.entity.FreeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomFreeBoardRepositoryImpl extends SimpleJpaRepository<FreeBoard, Long> implements CustomFreeBoardRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public CustomFreeBoardRepositoryImpl(EntityManager entityManager) {
        super(FreeBoard.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<FreeBoard> findAllWithPagination(Pageable pageable) {
        String sql = "SELECT * FROM free_board ORDER BY free_board_idx DESC ODERS LIMIT :limit OFFSET :offset";
        Query query = entityManager.createNativeQuery(sql, FreeBoard.class);
        query.setParameter("limit", pageable.getPageSize());
        query.setParameter("offset", pageable.getOffset());

        List<FreeBoard> freeBoards = query.getResultList();

        String countSql = "SELECT COUNT(*) FROM free_board";
        Query countQuery = entityManager.createNativeQuery(countSql);
        Number totalCount = (Number) countQuery.getSingleResult();

        return new PageImpl<>(freeBoards, pageable, totalCount.longValue());
    }
}
