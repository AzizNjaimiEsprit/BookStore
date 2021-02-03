package tn.esprit.BookStore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rate;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Rate(int id, int rate, Book book, User user) {
        this.id = id;
        this.rate = rate;
        this.book = book;
        this.user = user;
    }

    public Rate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate1 = (Rate) o;
        return getId() == rate1.getId() &&
                getRate() == rate1.getRate() &&
                Objects.equals(getBook(), rate1.getBook()) &&
                Objects.equals(getUser(), rate1.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRate(), getBook(), getUser());
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id=" + id +
                ", rate=" + rate +
                ", book=" + book.getId() +
                ", user=" + user.getId() +
                '}';
    }
}
