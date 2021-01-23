package tn.esprit.BookStore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "offers")
public class Offer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private String title;
    private String description;
    private String author;
    private float price;
    private String image;
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "offer_date")
    private java.sql.Timestamp offerDate;
}
