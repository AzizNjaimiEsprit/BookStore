package tn.esprit.BookStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Category;
import tn.esprit.BookStore.service.BasketServiceImpl;
import tn.esprit.BookStore.service.CategoryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;



    @GetMapping("/findAll")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping ("/")
    public Category findByName(String name) {
        return categoryService.findByName(name);
    }

    @PostMapping
    public Category create(Category category) {
        return categoryService.create(category);
    }

    @PutMapping("/")
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }


}
