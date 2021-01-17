package tn.esprit.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Rate;
import tn.esprit.BookStore.service.RateServiceImp;

@RequestMapping("api/rate")
@RestController
public class RateController {
    @Autowired
    RateServiceImp rateServiceImp;

    @PostMapping("/addRate")
    public void addRate(@RequestBody Rate r) {
        rateServiceImp.addRate(r);
    }

    @PostMapping("/deleteRate")
    public void deleteRate(@RequestBody Rate r) {
        rateServiceImp.deleteRate(r);
    }

    @PostMapping("/updateRate")
    public void updateRate(@RequestBody Rate r) {
        rateServiceImp.updateRate(r);
    }


    @GetMapping("/getListRate")
    public Rate getListRate(@RequestBody Rate r) {
        return rateServiceImp.getRate(r);
    }

    @GetMapping("/getMoyRate")
    public double getMoyRate(@RequestBody Book b) {
        return rateServiceImp.getMoyRates(b);
    }

}
