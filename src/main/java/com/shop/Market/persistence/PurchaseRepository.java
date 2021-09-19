package com.shop.Market.persistence;

import com.shop.Market.domain.PurchaseDomain;
import com.shop.Market.persistence.crud.PurchaseCrudRepository;
import com.shop.Market.persistence.entity.Purchase;
import com.shop.Market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class PurchaseRepository implements com.shop.Market.domain.repository.PurchaseRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<PurchaseDomain> getAll() {
        return purchaseMapper.toPurchasesDomain((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDomain>> getByClient(String clientId) {
        return purchaseCrudRepository.findByIdCustomer(clientId).map(Purchase -> purchaseMapper.toPurchasesDomain(Purchase));
    }

    @Override
    public PurchaseDomain save(PurchaseDomain purchaseDomain) {
        Purchase purchase = purchaseMapper.toPurchase(purchaseDomain);
        purchase.getProducts().forEach(product -> product.setPurchase(purchase));

        return purchaseMapper.toPurchaseDomain(purchaseCrudRepository.save(purchase));
    }
}
