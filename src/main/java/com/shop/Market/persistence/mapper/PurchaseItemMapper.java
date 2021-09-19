package com.shop.Market.persistence.mapper;

import com.shop.Market.domain.PurchaseItemDomain;
import com.shop.Market.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "amount", target = "quantity"),
            @Mapping(source = "state", target = "active")
    })
    PurchaseItemDomain toPurchaseItemDomain(PurchaseProduct purchaseProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true)
    })
    PurchaseProduct toPurchaseProduct(PurchaseItemDomain purchaseItemDomain);
}
