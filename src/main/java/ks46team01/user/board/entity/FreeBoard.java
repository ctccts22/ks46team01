package ks46team01.user.board.entity;

import jakarta.persistence.*;
import ks46team01.user.info.entity.User;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "free_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "free_board_idx")
    private Long freeBoardIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User username;

    @Column(name = "free_board_title", nullable = false)
    private String freeBoardTitle;

    @Column(name = "free_board_content", nullable = false)
    private String freeBoardContent;

    @Column(name = "free_board_date", nullable = false)
    private LocalDateTime freeBoardDate;

    @Column(name = "free_board_view", nullable = false)
    private Integer freeBoardView;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FreeBoard freeBoard = (FreeBoard) o;
        return Objects.equals(freeBoardIdx, freeBoard.freeBoardIdx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freeBoardIdx);
    }

}
