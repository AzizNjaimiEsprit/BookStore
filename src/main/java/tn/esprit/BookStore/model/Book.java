package tn.esprit.BookStore.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
@ToString
public class Book {
    @Id
    @Column
    private int id;

    private String title;

    private double price;

    private String pubHouse;

    private String summary;

    private Date releaseDate;

    private int quantity;

    private String status;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String image;

    private int nbPage;

    private String Authors;

    private boolean isDiscounted = false;

    public Book(int id) {
        this.id = id;
    }


}
