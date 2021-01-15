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
    @Column
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    private List<OrderItem> items;
    @Column
    private float totalPrice;
    @Column
    private String paymentID;
    @Column
    private String orderDate;
    @Column
    private String address;
    @Column
    private int zipCode;
    @Column
    private String numTel;
    @Column
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
