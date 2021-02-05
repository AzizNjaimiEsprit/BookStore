package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.User;
import tn.esprit.BookStore.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class BookServiceImp implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    OrderService orderService;
    @Autowired
    MaillingService maillingService;

    @Override
    public Book addBook(Book b) {
        Book res = bookRepository.save(b);
        String category=b.getCategory().getName();
        Map<String, List<User>> matching = orderService.getClientsFavouriteCategories();
        List<User> users = matching.get(category);
        if(users!=null)
        for (User i:users)
        {
          maillingService.sendMatchingEmail(i,b);
        }
        return res;
    }

    @Override
    public void deleteBook(Book b) {
        bookRepository.delete(b);
    }

    @Override
    public void updateBook(Book b) {
        bookRepository.save(b);
    }

    @Override
    public ArrayList<Book> getBookList() {
        return (ArrayList<Book>) bookRepository.findAll();
    }

    @Override
    public Book getBook(Book b) {
        return bookRepository.findById(b.getId()).get();
    }

    @Transactional
    @Override
    public Book getBookByID(int id) {
        System.out.println("***************************"+id);
        Optional<Book> op = bookRepository.findById(id);
        if (op.isPresent())
            return op.get();
        return null;
    }

    @Override
    public int getQuantity(int id) {

        return bookRepository.findById(id).get().getQuantity();
    }

    @Override
    public void setQuantity(int id, int newQ) {
       bookRepository.findById(id).get().setQuantity(newQ);
    }
}
