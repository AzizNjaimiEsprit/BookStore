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
    public void AjouterCommentaire(Comment c) {
        commentRepository.save(c);
    }

    @Override
    public void SupprimerComment(Comment c) {
         commentRepository.delete(c);
    }

    @Override
    public void ModifierComment(Comment c) {
        commentRepository.save(c);
    }

//    @Override
//    public List<Comment> RecupererListComment(int id ) {
//        return commentRepository.findAll
//    }
}
