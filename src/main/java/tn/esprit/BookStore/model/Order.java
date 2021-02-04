package tn.esprit.BookStore.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * @author Njaimi Med Aziz
 */
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    private List<OrderItem> items;

    private float totalPrice;

    private String paymentID;

    private String orderDate;

    private String address;

    private int zipCode;

    private String numTel;

    private String status;

    public Order(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", items:`\n" + items +
                ", totalPrice=" + totalPrice +
                ", paymentID='" + paymentID + '\'' +
                ", orderDate=" + orderDate +
                ", address=" + address +
                ", zipcode=" + zipCode +
                ", numTel=" + numTel +
                ", status='" + status + '\'' +
                '}';
    }

}
