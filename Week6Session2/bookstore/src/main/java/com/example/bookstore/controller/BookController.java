package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //get all books
    @GetMapping
    public List<BookDTO> getBooks(){
        return bookService.getAllBooks();
    }
    // get books by author

    // create a new book
    @PostMapping
    public BookDTO createBook(@RequestBody Book book, @RequestParam Integer authorId) {
        Book savedBook = bookService.createBook(book, authorId);
        BookDTO bookdto = new BookDTO(
                savedBook.getId(),
                savedBook.getTitle(),
                savedBook.getAuthor().getName()
        );

        return bookdto;
    }




}
