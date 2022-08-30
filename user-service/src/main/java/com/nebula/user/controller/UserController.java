package com.nebula.user.controller;

import com.nebula.user.VO.ResponseTemplateVO;
import com.nebula.user.entity.Users;
import com.nebula.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Users saveUser(@RequestBody Users user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        return userService.getUserWithDepartment(userId);

    }
}
