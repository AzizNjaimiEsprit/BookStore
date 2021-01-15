package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Comment;
import tn.esprit.BookStore.repository.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Override
    public void addComment(Comment c) {
        commentRepository.save(c);
    }

    @Override
    public void deleteComment(Comment c) {
         commentRepository.delete(c);
    }

    @Override
    public void updateComment(Comment c) {
        commentRepository.save(c);
    }

    @Override
    public List<Comment> getListComment(Book b) {
        return commentRepository.getAllComment(b.getId());
    }


}
