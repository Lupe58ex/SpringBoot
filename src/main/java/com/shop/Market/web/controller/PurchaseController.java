package com.shop.Market.web.controller;

import com.shop.Market.domain.PurchaseDomain;
import com.shop.Market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/")
    public ResponseEntity<List<PurchaseDomain>> getAll(){
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PurchaseDomain>> getByClient(@PathVariable("id") String clientId) {
        return purchaseService.getByClient(clientId).map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PurchaseDomain> save(@RequestBody PurchaseDomain purchaseDomain){
        return new ResponseEntity(purchaseService.save(purchaseDomain), HttpStatus.CREATED);
    }
}
