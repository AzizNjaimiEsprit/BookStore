package tn.esprit.BookStore.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
@Entity
public class FavoriteCategorie implements Serializable {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private FavouriteCategorieFK FavouriteCategorieFK;

    @ManyToOne(fetch=FetchType.EAGER)
    @MapsId("user_id")
    @JoinColumn(name="user_id")
    private User User; 
    
    @ManyToOne(fetch=FetchType.EAGER)
    @MapsId("category_id")
    @JoinColumn(name="category_id")
    private Category Category;

	public FavouriteCategorieFK getFavouriteCategorieFK() {
		return FavouriteCategorieFK;
	}

	public void setFavouriteCategorieFK(FavouriteCategorieFK favouriteCategorieFK) {
		FavouriteCategorieFK = favouriteCategorieFK;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		Category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FavoriteCategorie(tn.esprit.BookStore.model.FavouriteCategorieFK favouriteCategorieFK,
			tn.esprit.BookStore.model.User user, tn.esprit.BookStore.model.Category category) {
		super();
		FavouriteCategorieFK = favouriteCategorieFK;
		User = user;
		Category = category;
	}

	public FavoriteCategorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FavoriteCategorie [FavouriteCategorieFK=" + FavouriteCategorieFK + ", User=" + User + ", Category="
				+ Category + "]";
	}


}
