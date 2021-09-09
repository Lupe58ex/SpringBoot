package com.shop.Market.persistence;

import com.shop.Market.persistence.crud.ProductCrudRepository;
import com.shop.Market.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int idCategory){
        return productCrudRepository.findByIdCategory(idCategory);
    }

    public Optional<List<Product>> getEscasos(int stock, boolean state){
        return productCrudRepository.findByStockLessThanAndState(stock, true);
    }
}
