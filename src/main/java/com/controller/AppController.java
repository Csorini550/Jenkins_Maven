package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mainapp")
public class AppController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public String loginValid(@RequestBody User user) {

      if(userService.loginValidate(user)) {
          return "user is validated";
      } else {
          return "Login failed";
      }
    }

    @PostMapping("/register")
    public String registrerUser(@ModelAttribute User user ) {
       userService.registrationValidation(user);

        return "Registration complete";
    }

    @GetMapping("/loadusers")
    public List<User> loadAll() {
        return userService.loadAll();
    }

   @GetMapping("/finduser/{uname}")
    public String findUser(@PathVariable String uname) {
        if (userService.findUser(uname)) {
            return "user: " + uname + " found";
        }
        return "user not found";
   }

    @DeleteMapping("/deleteuser/{uname}")
    public String deleteUser(@PathVariable String uname) {
        if (userService.deleteUser(uname)) {
            return "user: " + uname + " deleted";
        }
        return "user not found";
    }

    @PutMapping("/updateuser/{uname}")
    public String updateUser(@PathVariable String uname, @PathVariable User user) {
        if (userService.updateUser(uname, user)) {
            return "user: " + uname + " deleted";
        }

        return "User not found";
    }


}
