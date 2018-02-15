package com.example.demo;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    RoomRepository roomList;

    @GetMapping("/")
    public String listrooms(Model model) {

        model.addAttribute("publicroom", roomList.findAll());
        model.addAttribute("fullroom", roomList.findAll());
        return "roomlist";
    }

    @GetMapping("/addroom")
    public String addbooks(Model model){
        model.addAttribute("room", new Room());
        return"addroom";
    }

    @PostMapping("/processroom")
    public String processRoom(@Valid Room room, BindingResult result) {
        if (result.hasErrors()) {
            return "addroom";
        }
        room.setRented(false);
        roomList.save(room);
        return "redirect:/listrooms";
    }
    @RequestMapping("/details/{id}")
    public String roomDetails(@PathVariable("id") long id, Model model){
        model.addAttribute("room", roomList.findOne(id));
        return "/roomdetails";
    }

    @GetMapping("/loginpage")
    public String loginpage(Model model){
        return "login";
    }

    @RequestMapping("/edit/{id}")
    public String roomEdit(@PathVariable("id") long id, Model model) {
        model.addAttribute("room", roomList.findOne(id));
        return "/roomdetails";

    }


}
