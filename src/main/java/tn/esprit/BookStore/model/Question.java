package tn.esprit.BookStore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(targetEntity=Answer.class)
    @JoinColumn(name="answer_id",referencedColumnName="id")
    private Answer answer;

    private String question;

    public Question() {
    }

    public Question(int id, Answer answer, String question) {
        this.id = id;
        this.answer = answer;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id &&
                Objects.equals(answer, question.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", answer=" + answer +
                ", question='" + question + '\'' +
                '}';
    }
}
