package com.assessment.skuservice.entity;

import com.sun.javafx.beans.IDProperty;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StockUnit {
    @Id
    @GeneratedValue
    private Long id;
    private String nameofItem;
    private long price;
}
