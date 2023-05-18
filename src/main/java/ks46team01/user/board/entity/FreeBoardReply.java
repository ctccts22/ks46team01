package ks46team01.user.board.entity;

import jakarta.persistence.*;
import ks46team01.user.info.entity.User;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "free_board_reply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoardReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "free_board_reply_idx")
    private Long freeBoardReplyIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "free_board_idx")
    private FreeBoard freeBoard;

    @Column(name = "free_board_reply_content", nullable = false)
    private String freeBoardReplyContent;

    @Column(name = "free_board_reply_date", nullable = false)
    private LocalDateTime freeBoardReplyDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FreeBoardReply freeBoardReply = (FreeBoardReply) o;
        return Objects.equals(freeBoardReplyIdx, freeBoardReply.freeBoardReplyIdx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freeBoardReplyIdx);
    }
}
