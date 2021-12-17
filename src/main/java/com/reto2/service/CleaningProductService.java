package com.reto2.service;

import com.reto2.model.CleaningProduct;
import com.reto2.repository.CleaningProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleaningProductService {
    @Autowired
    private CleaningProductRepository cleaningprodRepository;

    public List<CleaningProduct> getAll() {
        return cleaningprodRepository.getAll();
    }

    public Optional<CleaningProduct> getClothe(Integer id) {
        return cleaningprodRepository.getClothe(id);
    }

    public CleaningProduct create(CleaningProduct cleaningprod) {
        if (cleaningprod.getId() == null) {
            return cleaningprod;
        } else {
            return cleaningprodRepository.create(cleaningprod);
        }
    }

    public CleaningProduct update(CleaningProduct cleaningprod) {

        if (cleaningprod.getId() != null) {
            Optional<CleaningProduct> dbCleaningprod = cleaningprodRepository.getClothe(cleaningprod.getId());
            if (!dbCleaningprod.isEmpty()) {

                if (cleaningprod.getBrand() != null) {
                    dbCleaningprod.get().setBrand(cleaningprod.getBrand());
                }

                if (cleaningprod.getCategory() != null) {
                    dbCleaningprod.get().setCategory(cleaningprod.getCategory());
                }

                if (cleaningprod.getPresentation() != null) {
                    dbCleaningprod.get().setPresentation(cleaningprod.getPresentation());
                }

                if (cleaningprod.getDescription() != null) {
                    dbCleaningprod.get().setDescription(cleaningprod.getDescription());
                }

                if (cleaningprod.getPrice() != 0.0) {
                    dbCleaningprod.get().setPrice(cleaningprod.getPrice());
                }

                if (cleaningprod.getQuantity() != 0) {
                    dbCleaningprod.get().setQuantity(cleaningprod.getQuantity());
                }

                if (cleaningprod.getPhotography() != null) {
                    dbCleaningprod.get().setPhotography(cleaningprod.getPhotography());
                }

                dbCleaningprod.get().setAvailability(cleaningprod.isAvailability());
                cleaningprodRepository.update(dbCleaningprod.get());
                return dbCleaningprod.get();
            } else {
                return cleaningprod;
            }
        } else {
            return cleaningprod;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getClothe(id).map(cleaningprod -> {
            cleaningprodRepository.delete(cleaningprod);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    // Reto 5
    public List<CleaningProduct> productByPrice(double price) {
        return cleaningprodRepository.productByPrice(price);
    }

    // Reto 5
    public List<CleaningProduct> findByDescriptionLike(String description) {
        return cleaningprodRepository.findByDescriptionLike(description);
    }
}
