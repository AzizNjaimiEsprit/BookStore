package tn.esprit.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.BookStore.model.FavoriteCategorie;
import tn.esprit.BookStore.repository.FavoriteCategorieRepository;

@RequestMapping("api/Favouritecat")
@RestController
public class FavouriteCategoryController {
	 @Autowired
	    FavoriteCategorieRepository fav_c;

	    @PostMapping("/addFa_c")
	    public void addFc(@RequestBody FavoriteCategorie b) {
	    	fav_c.save(b);
	    }

	 

	    @GetMapping("/getFa_cList")
	    public Iterable<FavoriteCategorie> getFcList() {
	        return fav_c.findAll();
	    }


}
