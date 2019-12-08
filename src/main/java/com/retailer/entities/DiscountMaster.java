package com.retailer.entities;

public class DiscountMaster {

    private Integer id;
    private Double slabMin;
    private Double slabMax;
    private Double discount;

    public DiscountMaster(Integer id, Double slabMin, Double slabMax, Double discount) {
	super();
	this.id = id;
	this.slabMin = slabMin;
	this.slabMax = slabMax;
	this.discount = discount;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Double getSlabMin() {
	return slabMin;
    }

    public void setSlabMin(Double slabMin) {
	this.slabMin = slabMin;
    }

    public Double getSlabMax() {
	return slabMax;
    }

    public void setSlabMax(Double slabMax) {
	this.slabMax = slabMax;
    }

    public Double getDiscount() {
	return discount;
    }

    public void setDiscount(Double discount) {
	this.discount = discount;
    }

}
