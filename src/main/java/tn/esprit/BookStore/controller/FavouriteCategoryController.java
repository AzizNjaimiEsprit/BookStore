package tn.esprit.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import tn.esprit.BookStore.model.Category;
import tn.esprit.BookStore.model.FavoriteCategorie;
import tn.esprit.BookStore.model.User;
import tn.esprit.BookStore.repository.CategoryRepository;
import tn.esprit.BookStore.repository.FavoriteCategorieRepository;

@RequestMapping("api/Favouritecat")
@RestController
public class FavouriteCategoryController {
	 @Autowired
	    FavoriteCategorieRepository fav_c;
@Autowired
	CategoryRepository ctr;
	    @PostMapping("/addFa_c")
	    public void addFc(@RequestBody FavoriteCategorie b) {
	    	fav_c.save(b);
	    }

	 

	    @GetMapping("/getFa_cList")
	    public Iterable<FavoriteCategorie> getFcList() {
	        return fav_c.findAll();
	    }

		@GetMapping("/getusrByFavCate/{id}")
		@ResponseBody
		public List<User> getFcListcateg(@PathVariable("id") Long id) {
			System.out.println(id);

	    	return fav_c.getAllUserByCategory(ctr.findById(id));
	}

}
