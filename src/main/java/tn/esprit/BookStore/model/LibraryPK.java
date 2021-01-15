package tn.esprit.BookStore.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LibraryPK implements Serializable {
    @Column(name = "book_id", nullable = false)
    private int book_id;
    @Column(name = "user_id", nullable = false)
    private int user_id;

    public LibraryPK() {
    }

    public LibraryPK(int book_id, int user_id) {
        this.book_id = book_id;
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
