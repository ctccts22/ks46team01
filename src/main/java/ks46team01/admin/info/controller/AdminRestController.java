package ks46team01.admin.info.controller;

import ks46team01.admin.info.service.AdminRestService;
import ks46team01.user.info.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class AdminRestController {

    private final AdminRestService adminRestService;

    @PostMapping("/listUser")
    public ResponseEntity<?> modifyUser(@RequestBody User updatedUser) {
        log.info("Received request to modify user: {}", updatedUser);
        adminRestService.modifyUser(updatedUser);

        return ResponseEntity.ok().build();
    }

}
