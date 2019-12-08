package com.retailer.entities;

public class Total {

    private Double totalAfterDiscount;
    private Double amountOff;

    public Total() {

    }

    public Total(Double discount, Double totalAfterDiscount, Double amountOff) {
	super();
	this.totalAfterDiscount = totalAfterDiscount;
	this.amountOff = amountOff;
    }

    public Double getTotalAfterDiscount() {
	return totalAfterDiscount;
    }

    public void setTotalAfterDiscount(Double totalAfterDiscount) {
	this.totalAfterDiscount = totalAfterDiscount;
    }

    public Double getAmountOff() {
	return amountOff;
    }

    public void setAmountOff(Double amountOff) {
	this.amountOff = amountOff;
    }

}
