package tn.esprit.BookStore.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Njaimi Med Aziz
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "coupon_usage_history")
public class CouponUsageHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "coupon_code", nullable = false)
    private Coupon coupon;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @Column(name = "usage_type")
    private String usageType;


    @Override
    public String toString() {
        return "CouponUsageHistory{" +
                "id=" + id +
                "coupon=" + coupon.getCode() +
                ", order=" + order.getId() +
                ", usageType='" + usageType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouponUsageHistory that = (CouponUsageHistory) o;
        return Objects.equals(coupon, that.coupon) &&
                Objects.equals(order, that.order) &&
                Objects.equals(usageType, that.usageType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coupon, order, usageType);
    }
}
