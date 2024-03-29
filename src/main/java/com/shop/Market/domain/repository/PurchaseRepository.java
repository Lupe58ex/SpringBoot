package com.shop.Market.domain.repository;

import com.shop.Market.domain.PurchaseDomain;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<PurchaseDomain> getAll();
    Optional<List<PurchaseDomain>> getByClient(String clientId);
    PurchaseDomain save(PurchaseDomain purchaseDomain);
}
