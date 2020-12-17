package tn.esprit.BookStore.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
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
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int id;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @OneToMany( targetEntity=OrderItem.class, mappedBy="order" )
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
                ", items:`\n" + OrderItem.afficherTab(items) +
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
