package com.reto2.controller;

import com.reto2.model.CleaningProduct;
import com.reto2.service.CleaningProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cleaningprod/")
@CrossOrigin("*")
public class CleaningProductController {
    @Autowired
    private CleaningProductService cleaningprodService;

    @GetMapping("/all")
    public List<CleaningProduct> getAll() {
        return cleaningprodService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CleaningProduct> getClothe(@PathVariable("id") Integer id) {
        return cleaningprodService.getClothe(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct create(@RequestBody CleaningProduct cleaningprod) {
        return cleaningprodService.create(cleaningprod);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct cleaningprod) {
        return cleaningprodService.update(cleaningprod);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return cleaningprodService.delete(id);
    }

    //Reto 5
    @GetMapping("/price/{price}")
    public List<CleaningProduct> gadgetsByPrice(@PathVariable("price") double precio) {
        return cleaningprodService.productByPrice(precio);
    }
    //Reto 5
    @GetMapping("/description/{description}")
    public List<CleaningProduct> findByDescriptionLike(@PathVariable("description") String description) {
        return cleaningprodService.findByDescriptionLike(description);
    }
}
