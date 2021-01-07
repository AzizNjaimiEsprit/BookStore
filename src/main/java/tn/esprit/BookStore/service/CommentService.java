package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Comment;

import java.util.List;

public interface CommentService {
    void AjouterCommentaire(Comment c);
    void SupprimerComment(Comment c);
    void ModifierComment(Comment c);
/*
    List<Comment> RecupererListComment(Book b);
*/
}
