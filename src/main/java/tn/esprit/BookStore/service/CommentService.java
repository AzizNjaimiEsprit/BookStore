package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment c);
    void deleteComment(Comment c);
    void updateComment(Comment c);
    List<Comment> getListComment(Book b);
}
