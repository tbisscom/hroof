package com.tbiss.hroof.controller.v1;

import com.tbiss.hroof.api.v1.model.user.UserDTO;
import com.tbiss.hroof.service.v1.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUsers(@RequestParam(value = "page" , required = false) Optional<Integer>
                                       page){

        return userService.findUserById(1);
    }


    @PostMapping("/")
    @ResponseBody
    public void postUser(UserDTO userDTO){

    }
}
