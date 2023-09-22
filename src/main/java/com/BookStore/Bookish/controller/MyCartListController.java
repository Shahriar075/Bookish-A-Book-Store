package com.BookStore.Bookish.controller;

import com.BookStore.Bookish.service.MyCartListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyCartListController {

    @Autowired
    MyCartListService myCartListService;

    @RequestMapping("/deleteMyId/{id}")
    public String deleteMyList(@PathVariable("id") int id)
    {
        myCartListService.deleteById(id);
        return "redirect:/my_cart";
    }
}
