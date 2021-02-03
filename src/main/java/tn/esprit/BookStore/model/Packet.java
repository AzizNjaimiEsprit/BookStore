package tn.esprit.BookStore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Packet implements Serializable{


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String objectif;
    @OneToMany(targetEntity=Book.class, mappedBy="pkt",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> booklist = new ArrayList<>();
    public Packet( String titre, String objectif) {
        super();
        this.titre = titre;
        this.objectif = objectif;

    }
    public Packet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getObjectif() {
        return objectif;
    }
    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packet packet = (Packet) o;
        return id == packet.id &&
                Objects.equals(titre, packet.titre) &&
                Objects.equals(objectif, packet.objectif);
    }

    @Override
    public String toString() {
        return "Packet{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", objectif='" + objectif + '\'' +
                ", booklist=" + booklist +
                '}';
    }
}
