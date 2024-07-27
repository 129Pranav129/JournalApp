package com.pranav.journalApp.controller;

import com.pranav.journalApp.entity.User;
import com.pranav.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers() {
        List<User> all= userService.getAll();
        if(all.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
    }

    @PostMapping("/create-admin")
    public ResponseEntity<?> createAdminUser(@RequestBody User user){
        try{
            userService.saveAdminUser(user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
        }

    }

}
