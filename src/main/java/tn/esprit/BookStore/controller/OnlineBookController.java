package tn.esprit.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.OnlineBook;
import tn.esprit.BookStore.service.OnlineBookServiceImp;

import java.util.ArrayList;

@RequestMapping("api/onlinebook")
@RestController
public class OnlineBookController {
    @Autowired
    OnlineBookServiceImp onlineBookServiceImp;

    @PostMapping("/addOnlineBook")
    public void addOnlineBook(@RequestBody OnlineBook b) {
        onlineBookServiceImp.addBook(b);
    }

    @PostMapping("/deleteOnlineBook")
    public void deletOnlineBook(@RequestBody OnlineBook b) {
        onlineBookServiceImp.deleteBook(b);
    }

    @PostMapping("/updateOnlineBook")
    public void updateOnlineBook(@RequestBody OnlineBook b) {
        onlineBookServiceImp.updateBook(b);
    }

    @GetMapping("/getOnlineBookList")
    public ArrayList<OnlineBook> getBookList() {
        return onlineBookServiceImp.getBookList();
    }

    @GetMapping("/getOnlineBook")
    public OnlineBook getBook(@RequestBody OnlineBook Book) {
        return onlineBookServiceImp.getBook(Book);
    }

    @GetMapping("/getOnlineBookbyId")
    public OnlineBook getOnlineBookbyId(@RequestBody int id) {
        return onlineBookServiceImp.getBookByID(id);
    }

    @GetMapping("/getOnlineQuantity")
    public int getOnlineQuantity(@RequestBody int id) {
        return onlineBookServiceImp.getQuantity(id);
    }


}
