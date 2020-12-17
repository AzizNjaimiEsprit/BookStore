package tn.esprit.BookStore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Njaimi Med Aziz
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int id;
    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    @JsonIgnore
    private Order order;
    @Column
    private int quantity;
    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId=" + order.getId() +
                ", quantity=" + quantity +
                ", bookId=" + book.getId() +
                '}';
    }

    public static String afficherTab(List<OrderItem> tab) {
        String res = "";
        for (int i = 0; i < tab.size(); i++)
            res += "\t" + tab.get(i).toString() + "\n";
        return res;
    }

}
