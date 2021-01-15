package tn.esprit.BookStore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rate;
    private int book_id;
    private int user_id;


    public Rate(int id, int book, int user, int rate) {
        this.id = id;
        this.book_id = book;
        this.user_id = user;
        this.rate = rate;
    }

    public Rate() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return this.rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getB() {
        return this.book_id;
    }

    public void setB(int b) {
        this.book_id = b;
    }

    public int getU() {
        return this.user_id;
    }

    public void setU(int u) {
        this.user_id = u;
    }

    public String toString() {
        return "Rate{id=" + this.id + ", rate=" + this.rate + ", b=" + this.book_id + ", u=" + this.user_id + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Rate rate1 = (Rate)o;
            return this.getId() == rate1.getId();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getId(), this.getRate(), this.book_id, this.user_id});
    }
}
