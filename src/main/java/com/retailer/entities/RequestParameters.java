package com.retailer.entities;

public class RequestParameters {

    private String customerType;
    private Double purchaseAmount;

    private Double discount;
    private Double maxSlab;
    private Double minSlab;

    public RequestParameters(Double discount, Double maxSlab, Double minSlab) {
	super();
	this.discount = discount;
	this.maxSlab = maxSlab;
	this.minSlab = minSlab;
    }

    public RequestParameters(String customerType, Double purchaseAmount) {
	super();
	this.purchaseAmount = purchaseAmount;
	this.customerType = customerType;
    }

    public Double getPurchaseAmount() {
	return purchaseAmount;
    }

    public void setPurchaseAmount(Double purchaseAmount) {
	this.purchaseAmount = purchaseAmount;
    }

    public Double getDiscount() {
	return discount;
    }

    public void setDiscount(Double discount) {
	this.discount = discount;
    }

    public Double getMaxSlab() {
	return maxSlab;
    }

    public void setMaxSlab(Double maxSlab) {
	this.maxSlab = maxSlab;
    }

    public Double getMinSlab() {
	return minSlab;
    }

    public void setMinSlab(Double minSlab) {
	this.minSlab = minSlab;
    }

    public String getCustomerType() {
	return customerType;
    }

    public void setCustomerType(String customerType) {
	this.customerType = customerType;
    }

}
