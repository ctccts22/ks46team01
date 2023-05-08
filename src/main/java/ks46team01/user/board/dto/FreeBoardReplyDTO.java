package ks46team01.user.board.dto;

import ks46team01.user.board.entity.FreeBoardReply;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
public class FreeBoardReplyDTO {

    private Long freeBoardReplyIdx;
    private String username;
    private Long freeBoardIdx;
    private String freeBoardReplyContent;
    private LocalDateTime freeBoardReplyDate;

    public FreeBoardReply toEntity() {
        FreeBoardReply freeBoardReply = new FreeBoardReply();
        BeanUtils.copyProperties(this, freeBoardReply);
        return freeBoardReply;
    }

    public static FreeBoardReplyDTO fromEntity(FreeBoardReply freeBoardReply) {
        FreeBoardReplyDTO freeBoardReplyDTO = new FreeBoardReplyDTO();
        BeanUtils.copyProperties(freeBoardReply, freeBoardReplyDTO);
        freeBoardReplyDTO.setUsername(freeBoardReply.getUsername().getUsername());
        freeBoardReplyDTO.setFreeBoardIdx(freeBoardReply.getFreeBoard().getFreeBoardIdx());
        return freeBoardReplyDTO;
    }

}
