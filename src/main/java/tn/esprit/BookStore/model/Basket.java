package tn.esprit.BookStore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Basket implements Serializable {
    @EmbeddedId
    private BasketPK id;
    private int quantity;
    @OneToOne
    @JoinColumn(name="user_id", insertable = false,updatable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="book_id",insertable = false,updatable = false)
    private Book book;


    public BasketPK getId() {
        return id;
    }

    public void setId(BasketPK id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return quantity == basket.quantity && Objects.equals(id, basket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
