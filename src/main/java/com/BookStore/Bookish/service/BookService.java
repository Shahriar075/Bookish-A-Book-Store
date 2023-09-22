package com.BookStore.Bookish.service;

import com.BookStore.Bookish.entity.Book;
import com.BookStore.Bookish.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void save(Book b)
    {
        bookRepository.save(b);
    }
    public List<Book> getALlBooks()
    {
        return bookRepository.findAll();
    }
    public Book getBookById(int id)
    {
        return bookRepository.findById(id).get();
    }
    public void deleteById(int id)
    {
        bookRepository.deleteById(id);
    }
}
