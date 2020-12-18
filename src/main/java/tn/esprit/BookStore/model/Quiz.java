package tn.esprit.BookStore.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Quiz implements Serializable {

    @Id
    @ManyToOne(targetEntity=User.class)
    @JoinColumn(name="user_id",referencedColumnName="id")
    private User user;
    @Id
    @ManyToOne(targetEntity=OnlineBook.class)
    @JoinColumn(name="book_id",referencedColumnName="id")
    private OnlineBook book;
    @Id
    @ManyToOne(targetEntity=Question.class)
    @JoinColumn(name="question_id",referencedColumnName="id")
    private Question question;

    public Quiz() {
    }

    public Quiz(User user, OnlineBook book, Question question) {
        this.user = user;
        this.book = book;
        this.question = question;
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
        return Objects.equals(user, quiz.user) &&
                Objects.equals(book, quiz.book) &&
                Objects.equals(question, quiz.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, book, question);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "user=" + user +
                ", book=" + book +
                ", question=" + question +
                '}';
    }
}
