package tn.esprit.BookStore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Quiz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private OnlineBook book;
    @ManyToOne
    @JoinColumn(name="question_id", nullable=false)
    private Question question;

    public Quiz() {
    }

    public Quiz(int id, OnlineBook book, Question question) {
        this.id = id;
        this.book = book;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OnlineBook getBook() {
        return book;
    }

    public void setBook(OnlineBook book) {
        this.book = book;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return id == quiz.id &&
                Objects.equals(book, quiz.book) &&
                Objects.equals(question, quiz.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, question);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", book=" + book +
                ", question=" + question +
                '}';
    }
}
