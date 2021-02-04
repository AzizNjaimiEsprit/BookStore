package tn.esprit.BookStore.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class FavouriteCategorieFK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long user_id;
    private Long category_id;
}
  