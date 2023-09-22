package com.BookStore.Bookish.service;

import com.BookStore.Bookish.entity.MyCartList;
import com.BookStore.Bookish.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyCartListService {
    @Autowired
    private MyBookRepository myBookRepository;
    public void saveMyBook(MyCartList book)
    {
        myBookRepository.save(book);
    }
    public List<MyCartList> getALlMyBooks()
    {
        return myBookRepository.findAll();
    }
    public void deleteById(int id)
    {
        myBookRepository.deleteById(id);
    }
}
