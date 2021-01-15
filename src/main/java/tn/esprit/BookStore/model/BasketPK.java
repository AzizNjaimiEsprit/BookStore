package com.esprit.store.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BasketPK implements Serializable {
    @Column(name = "book_id", nullable = false)
    private int book_id;
    @Column(name = "user_id", nullable = false)
    private int user_id;

    public BasketPK(int book_id,int user_id) {
        this.book_id = book_id;
        this.user_id = user_id;
    }

    public BasketPK() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketPK basketPK = (BasketPK) o;
        return book_id == basketPK.book_id && user_id == basketPK.user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id, user_id);
    }

    @Override
    public String toString() {
        return "BasketPK{" +
                "book_id=" + book_id +
                ", user_id=" + user_id +
                '}';
    }
}
