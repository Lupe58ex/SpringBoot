package com.shop.Market.persistence.mapper;

import com.shop.Market.domain.ProductDomain;
import com.shop.Market.domain.PurchaseDomain;
import com.shop.Market.persistence.entity.Product;
import com.shop.Market.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "id", target = "purchaseId"),
            @Mapping(source = "idCustomer", target = "clientId"),
            @Mapping(source = "methodPaid", target = "paymentMethod"),
            @Mapping(source = "products", target = "items"),
    })
    PurchaseDomain toPurchaseDomain(Purchase purchase);
    List<PurchaseDomain> toPurchasesDomain(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "customer", ignore = true)
    Purchase toPurchase(PurchaseDomain purchaseDomain);
}
