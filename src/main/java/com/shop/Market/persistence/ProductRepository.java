package com.shop.Market.persistence;

import com.shop.Market.domain.ProductDomain;
import com.shop.Market.persistence.crud.ProductCrudRepository;
import com.shop.Market.persistence.entity.Product;
import com.shop.Market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements com.shop.Market.domain.repository.ProductRepository  {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;
    @Override
    public List<ProductDomain> getAll(){
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<ProductDomain>> getByCategory(int idCategory){
        List<Product> products = productCrudRepository.findByIdCategory(idCategory);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<ProductDomain>> getScarseProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockLessThanAndState(quantity, true);
        return products.map(prods -> mapper.toProducts(prods));
    }

    public Optional<ProductDomain> getProduct(int idProduct){
        return productCrudRepository.findById(idProduct).map((product -> mapper.toProductDomain(product)));
    }

    @Override
    public ProductDomain save(ProductDomain productDomain) {
        Product product = mapper.toProduct(productDomain);
        return mapper.toProductDomain(productCrudRepository.save(product));
    }

    public void delete(int idProduct){
        productCrudRepository.deleteById(idProduct);
    }
}
