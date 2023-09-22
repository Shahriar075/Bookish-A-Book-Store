package com.BookStore.Bookish.controller;

import com.BookStore.Bookish.entity.Book;
import com.BookStore.Bookish.entity.MyCartList;
import com.BookStore.Bookish.service.BookService;
import com.BookStore.Bookish.service.MyCartListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private MyCartListService myCartListService;

    @GetMapping("/")
    public String home()
    {
        return "home";
    }
    @GetMapping("/register_Books")
    public String RegisterBooks()
    {
        return "RegisterBooks";
    }
    @GetMapping("/book_categories")
    public ModelAndView getAllBooks()
    {
        List<Book> list=bookService.getALlBooks();
        //ModelAndView modelAndView=new ModelAndView();
        //modelAndView.setViewName("BooksCategories");
        //modelAndView.addObject("books",list);
        return new ModelAndView("BooksCategories","books",list);
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b)
    {
        bookService.save(b);
        return "redirect:/book_categories";
    }
    @GetMapping("/my_cart")
    public String getMyBooks(Model model)
    {
        List<MyCartList> list=myCartListService.getALlMyBooks();
        model.addAttribute("books",list);
        return "myCarts";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id)
    {
        Book book= bookService.getBookById(id);
        MyCartList myCartList=new MyCartList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
        myCartListService.saveMyBook(myCartList);
        return "redirect:/my_cart";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model)
    {
        Book book=bookService.getBookById(id);
        model.addAttribute("books",book);
        return "EditBook";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id)
    {
        bookService.deleteById(id);
        return "redirect:/book_categories";
    }
}
