package com.reto2.interfaces;

import java.util.List;

import com.reto2.model.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CleaningProductInterface extends MongoRepository<CleaningProduct, Integer> {

    public List<CleaningProduct> findByPriceLessThanEqual(double precio);
    // Reto 5

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<CleaningProduct> findByDescriptionLike(String description);
}
