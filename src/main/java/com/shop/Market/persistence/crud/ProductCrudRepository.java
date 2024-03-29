package com.shop.Market.persistence.crud;

import com.shop.Market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    List<Product> findByIdCategory(int idCategory);

    Optional<List<Product>> findByStockLessThanAndState(int stock, boolean state);
}
