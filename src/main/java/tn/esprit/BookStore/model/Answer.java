package tn.esprit.BookStore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name="first_answer")
    private String firstAnswer;
    @Column(name="second_answer")
    private String secondAnswer;
    @Column(name="third_answer")
    private String thirdAnswer;
    @Column(name="correct_answer")
    private String correctAnswer;

    public Answer(int id,String firstAnswer, String secondAnswer, String thirdAnswer, String correctAnswer) {
        this.id=id;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.correctAnswer = correctAnswer;
    }

    public Answer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id == answer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", firstAnswer='" + firstAnswer + '\'' +
                ", secondAnswer='" + secondAnswer + '\'' +
                ", thirdAnswer='" + thirdAnswer + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
