package tn.esprit.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.entities.Book;
import tn.esprit.BookStore.entities.Library;
import tn.esprit.BookStore.entities.User;
import tn.esprit.BookStore.exception.ApiRequestException;
import tn.esprit.BookStore.service.IChatBot;
import tn.esprit.BookStore.service.LibraryService;
import tn.esprit.BookStore.service.SmsSender;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @Autowired
    SmsSender smsSender;

    @Autowired
    IChatBot chatBot;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/addLibrary", produces = { "application/json"})
    public Library addLibrary(@RequestBody Library library){
        return libraryService.addLibrary(library);
    }

    @PutMapping("/addBookLibrary")
    public void addBookToLibrary(@RequestBody Library library){
        libraryService.addBookLibrary(library);
    }


    @GetMapping(value = "/", produces = { "application/json"})
    public List<Library> getLibraryitemByUser(@RequestBody Library library){
        return libraryService.findLibraryByUserId(library);
    }

    @PutMapping("/update")
    public void updateLibrary(@RequestBody Library library){
        libraryService.editLibrary(library);
    }

    @GetMapping("/read")
    public void openBook(@RequestBody Library library, HttpServletResponse response) throws IOException {
            libraryService.readBook(library,response);
    }

    @GetMapping("/sendSms")
    public void sendSms(@RequestBody Library library){
        smsSender.sendSms(library);
    }

    @GetMapping(value = "/suggestBook", produces = { "application/json"})
    public Book suggestBook(@RequestBody User user){
        return libraryService.suggestBook(user);
    }
}
