package com.example.library.controller;

import com.example.library.model.Author;
import com.example.library.service.AuthorService;
import com.example.library.service.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthorController {

    private final AuthorService authorService;
    private final RabbitMQProducer producer;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable("id") int id) {
        producer.sendMessage("*****RABBITMQ CONFIG WORKS*****");
        return authorService.getAuthorById(id);
    }
}