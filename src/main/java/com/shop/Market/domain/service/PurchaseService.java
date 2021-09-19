package com.shop.Market.domain.service;

import com.shop.Market.domain.ProductDomain;
import com.shop.Market.domain.PurchaseDomain;
import com.shop.Market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<PurchaseDomain> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<PurchaseDomain>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

    public PurchaseDomain save(PurchaseDomain purchaseDomain) {
        return  purchaseRepository.save(purchaseDomain);
    }
}
