package tn.esprit.BookStore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private int book_id;
    private int user_id;


    public Comment(int id, String text, int b, int u) {
        this.id = id;
        this.text = text;
        this.book_id = b;
        this.user_id = u;
    }

    public Comment() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getBook() {
        return book_id;
    }

    public void setBook(int book) {
        this.book_id = book;
    }

    public int getUser() {
        return user_id;
    }

    public void setUser(int user) {
        this.user_id = user;
    }

  /*  //EXTRA
    public String getUserFullName() {
        return this.user.getFullName();
    }*/

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", b=" + book_id+
                ", u=" + user_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return getId() == comment.getId() &&
                Objects.equals(getText(), comment.getText()) &&
                Objects.equals(getBook(), comment.getBook()) &&
                Objects.equals(getUser(), comment.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getText(), getBook(), getUser());
    }
}
