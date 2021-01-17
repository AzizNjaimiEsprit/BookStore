package tn.esprit.BookStore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Library implements Serializable {

    @EmbeddedId
    private LibraryPK id;

    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false, nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", insertable = false, updatable = false, nullable = false)
    private OnlineBook book;

    @Column(name = "status", columnDefinition = "varchar(20) default 'Recently added'")
    private String status;
    @Column(name = "page_reached", columnDefinition = "integer default 0")
    private int reachedPage;
    @Column(name = "quiz_score", columnDefinition = "integer default 0")
    private int quizScore;

    public Library() {

    }

    public Library(LibraryPK id, User user, OnlineBook book, String status, int reachedPage, int quizScore) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.status = status;
        this.reachedPage = reachedPage;
        this.quizScore = quizScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(id, library.id) &&
                Objects.equals(user, library.user) &&
                Objects.equals(book, library.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, book);
    }

    public LibraryPK getId() {
        return id;
    }

    public void setId(LibraryPK id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OnlineBook getBook() {
        return book;
    }

    public void setBook(OnlineBook book) {
        this.book = book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReachedPage() {
        return reachedPage;
    }

    public void setReachedPage(int reachedPage) {
        this.reachedPage = reachedPage;
    }

    public int getQuizScore() {
        return quizScore;
    }

    public void setQuizScore(int quizScore) {
        this.quizScore = quizScore;
    }


    @Override
    public String toString() {
        return "Library{" +
                "user=" + user +
                ", book=" + book +
                ", status='" + status + '\'' +
                ", reachedPage=" + reachedPage +
                ", quizScore=" + quizScore +
                '}';
    }

}
