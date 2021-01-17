package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Comment;
import tn.esprit.BookStore.model.User;
import tn.esprit.BookStore.repository.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserService userService;
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

    @Transactional
    @Override
    public User getTopFan() {
        List<Object[]> list  = commentRepository.getTopFan();
        for (Object[] obj : list)
        { return userService.GetUser(Long.parseLong(obj[1].toString())); }
        return null;
    }


}
