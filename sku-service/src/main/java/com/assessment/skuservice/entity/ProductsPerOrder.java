package com.assessment.skuservice.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductsPerOrder {

    @EmbeddedId
    private CombinedKey id;

    private int numberOfItems;

    public ProductsPerOrder() {
        super();
    }

    public ProductsPerOrder(CombinedKey id, int numberOfItems) {
        this.id = id;
        this.numberOfItems = numberOfItems;
    }

    public CombinedKey getId() {
        return id;
    }

    public void setId(CombinedKey id) {
        this.id = id;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}
