package ks46team01.user.info.dto;
import ks46team01.user.info.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;


import java.sql.Timestamp;


@Data
@RequiredArgsConstructor
public class UserDTO {
    private String username;
    private String password;
    private Long roleIdx;
    private String name;
    private java.sql.Date birth;
    private String email;
    private String phone;
    private String address;
    private Timestamp date;
    private Timestamp modifyDate;
    private String isDel;
    private Timestamp isDelDate;


    public User toEntity() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }

    public static UserDTO fromEntity(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        userDTO.setRoleIdx(user.getRoleIdx().getRoleIdx());
        return userDTO;
    }
}
