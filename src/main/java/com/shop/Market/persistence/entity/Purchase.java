package com.shop.Market.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer id;

    @Column(name = "id_cliente")
    private Integer idCustomer;

    @Column(name = "fecha")
    private LocalDateTime date;

    @Column(name = "medio_pago")
    private String halfPaid;

    @Column(name = "comentario")
    private String comment;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "product")
    private List<PurchaseProduct> products;

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", idCustomer=" + idCustomer +
                ", date=" + date +
                ", halfPaid='" + halfPaid + '\'' +
                ", comment='" + comment + '\'' +
                ", state=" + state +
                '}';
    }

    public Purchase(Integer id, Integer idCustomer, LocalDateTime date, String halfPaid, String comment, Boolean state) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.date = date;
        this.halfPaid = halfPaid;
        this.comment = comment;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getHalfPaid() {
        return halfPaid;
    }

    public void setHalfPaid(String halfPaid) {
        this.halfPaid = halfPaid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
