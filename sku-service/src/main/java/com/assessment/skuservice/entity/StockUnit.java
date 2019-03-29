package com.assessment.skuservice.entity;

import com.sun.javafx.beans.IDProperty;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StockUnit {
    @Id
    //@GeneratedValue
    private String id;
    private String nameofItem;
    private long price;
    private int numberOfItems;

    public StockUnit(){
        super();
    }

    public StockUnit(String id, String nameofItem, long price, int numberOfItems) {
        this.id = id;
        this.nameofItem = nameofItem;
        this.price = price;
        this.numberOfItems = numberOfItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameofItem() {
        return nameofItem;
    }

    public void setNameofItem(String nameofItem) {
        this.nameofItem = nameofItem;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}
