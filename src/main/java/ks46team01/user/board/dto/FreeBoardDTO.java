package ks46team01.user.board.dto;

import ks46team01.user.board.entity.FreeBoard;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
@Data
public class FreeBoardDTO {

    private Long freeBoardIdx;
    private String username;
    private String freeBoardTitle;
    private String freeBoardContent;
    private LocalDateTime freeBoardDate;
    private Integer freeBoardView;

    public FreeBoard toEntity() {
        FreeBoard freeBoard = new FreeBoard();
        BeanUtils.copyProperties(this, freeBoard);
        return freeBoard;
    }

    public static FreeBoardDTO fromEntity(FreeBoard freeBoard) {
        FreeBoardDTO freeBoardDTO = new FreeBoardDTO();
        BeanUtils.copyProperties(freeBoard, freeBoardDTO);
        freeBoardDTO.setUsername(freeBoard.getUsername().getUsername());
        return freeBoardDTO;
    }

}
