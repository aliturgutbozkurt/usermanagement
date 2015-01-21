package com.n11.controller;

import com.n11.model.User;
import com.n11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by atb on 1/16/2015.
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = {"/save","/"},
            consumes = "application/json",
            produces = "application/json",
            method = {RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public User saveOrUpdate(@RequestBody User user) {
        User saved = repository.save(user);
        return saved;
    }


    @RequestMapping(value = "/all",
            produces = "application/json",
            method = {RequestMethod.GET})
    @ResponseBody
    public List<User> getAllUsers() {
        List<User> userList = repository.findAll();
        return userList;
    }

    @RequestMapping(value = "/delete/{id}",
            produces = "application/json",
            method = {RequestMethod.DELETE})
    @ResponseBody
    public void deleteAUser(@PathVariable("id") String id) {
        repository.delete(id);
    }

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

}
