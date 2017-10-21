package com.example.restclientdemo.client.controller;

import com.example.restclientdemo.client.service.RestClient;
import com.example.restclientdemo.client.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/")
@Controller
public class ClientController {

    private RestClient restClient = new RestClient();



    @GetMapping("users")
    public String getAll(Model model){
        model.addAttribute("users", restClient.getAllUsers());
        return "users";
    }

    @DeleteMapping
    public String delete(@RequestParam Long id){
        restClient.delete(id);
        return "redirect:/users";
    }

    @RequestMapping("user/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "newuser";
    }

    /**
     *
     * @param user from User object in client package
     * @return String
     */
    @PostMapping("user")
    public String create(@Valid User user){
            restClient.postUser(user);
            System.out.println("posted");
            return "redirect:/users";

    }

    @RequestMapping("user/edit")
    public String editUser(Model model){
        model.addAttribute("user", new User());
        return "edituser";
    }

    @PutMapping("update")
    public String update(@RequestParam Long id, User user ) {
        restClient.update(id, user);
        System.out.println("updated");
        return "redirect:/users";
    }


}
