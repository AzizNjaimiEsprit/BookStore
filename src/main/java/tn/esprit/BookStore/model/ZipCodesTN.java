package tn.esprit.BookStore.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table
public class ZipCodesTN implements Serializable{
    @Id
    private String governorate;

    private int code;
}
