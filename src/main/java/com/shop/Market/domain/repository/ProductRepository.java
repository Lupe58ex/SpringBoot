package com.shop.Market.domain.repository;

import com.shop.Market.domain.ProductDomain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDomain> getAll();
    Optional<List<ProductDomain>> getByCategory(int categoryId);
    Optional<List<ProductDomain>> getScarseProducts(int quantity);
    Optional<ProductDomain> getProduct(int productId);
    ProductDomain save(ProductDomain product);
    void delete(int productId);
}
