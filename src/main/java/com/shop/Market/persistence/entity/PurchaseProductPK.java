package com.shop.Market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//it must has the same name of id of the others entities relation
@Embeddable
public class PurchaseProductPK implements Serializable {
    @Column(name = "id_compra")
    private Integer id;

    @Column(name = "id_producto")
    private Integer idProduct;

    public Integer getIdPurchase() {
        return id;
    }

    public void setIdPurchase(Integer idPurchase) {
        this.id = idPurchase;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }
}
