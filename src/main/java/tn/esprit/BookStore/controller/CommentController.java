package tn.esprit.BookStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Comment;
import tn.esprit.BookStore.model.User;
import tn.esprit.BookStore.service.CommentServiceImp;

import java.util.List;

@RequestMapping("api/comment")
@RestController
public class CommentController {
    @Autowired
    CommentServiceImp commentServiceImp;


    @PostMapping("/addComment")
    public void addComment(@RequestBody Comment c) {
        commentServiceImp.addComment(c);
    }

    @PostMapping("/deleteComment")
    public void deleteComment(@RequestBody Comment c) {
        commentServiceImp.deleteComment(c);
    }

    @PostMapping("/updateComment")
    public void updateComment(@RequestBody Comment c) {
        commentServiceImp.updateComment(c);
    }


    @GetMapping("/getListComment")
    public List<Comment> getListComment(@RequestBody Book b) {
        return commentServiceImp.getListComment(b);
    }

    @GetMapping("getTopFan")
    public User getTopFan (){return commentServiceImp.getTopFan();}

}
