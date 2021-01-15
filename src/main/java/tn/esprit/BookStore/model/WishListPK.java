package com.esprit.store.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WishListPK implements Serializable {
    @Column(name = "book_id", nullable = false)
    private int book_id;
    @Column(name = "user_id", nullable = false)
    private int user_id;

    public WishListPK(int book_id,int user_id) {
        this.book_id = book_id;
        this.user_id = user_id;
    }
    public WishListPK() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishListPK wishListPK = (WishListPK) o;
        return book_id == wishListPK.book_id &&
                user_id == wishListPK.user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id, user_id);
    }

}
