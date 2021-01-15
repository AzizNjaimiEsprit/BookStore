
package tn.esprit.BookStore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="wishlist")
public class WishList implements Serializable {
    @EmbeddedId
    private WishListPK id;
    @OneToOne
    @JoinColumn(name="user_id", insertable = false,updatable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="book_id",insertable = false,updatable = false)
    private Book book;


    public WishList() {
    }

    public WishList(WishListPK id) {
        this.id = id;
    }

    public WishListPK getId() {
        return id;
    }

    public void setId(WishListPK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishList wishList = (WishList) o;
        return Objects.equals(id, wishList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                '}';
    }
}

