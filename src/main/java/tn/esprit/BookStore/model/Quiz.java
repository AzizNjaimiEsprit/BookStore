package tn.esprit.BookStore.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Quiz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonManagedReference
    @OneToMany(mappedBy="quiz")
    private Set<Question> questions = new HashSet<Question>();

    @OneToOne
    @JoinColumn(name = "online_book_id")
    private OnlineBook onlineBook;

    @OneToOne
    private User user;

    @Column(columnDefinition = "integer default 0")
    private int quizScore;

    public Quiz() {
    }

    public Quiz(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public OnlineBook getOnlineBook() {
        return onlineBook;
    }

    public void setOnlineBook(OnlineBook onlineBook) {
        this.onlineBook = onlineBook;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuizScore() {
        return quizScore;
    }

    public void setQuizScore(int quizScore) {
        this.quizScore = quizScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return id == quiz.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", onlineBook=" + onlineBook +
                ", user=" + user +
                ", quizScore=" + quizScore +
                '}';
    }
}
