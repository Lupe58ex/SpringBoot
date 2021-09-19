package com.shop.Market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProduct;

    @Column(name = "nombre")
    private String name;

    @Column(name = "id_categoria")
    private Integer idCategory;

    @Column(name = "codigo_barras")
    private String barCode;

    @Column(name = "precio_venta")
    private Double sellPrice;

    @Column(name = "cantidad_stock")
    private Integer stock;

    @Column(name = "estado")
    private  Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Category category;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseProduct> purchases;



    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", idCategory=" + idCategory +
                ", barCode='" + barCode + '\'' +
                ", sellPrice=" + sellPrice +
                ", stock=" + stock +
                ", state=" + state +
                '}';
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
