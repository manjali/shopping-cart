package com.assessment.skuservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.javafx.beans.IDProperty;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity(name="stock_unit")
@Table(name="stock_unit")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockUnit {
    @Id
    //@GeneratedValue
    private String id;
    @Column(name="name_of_item")
    private String nameofItem;
    private long price;
    @Column(name="number_of_items")
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
