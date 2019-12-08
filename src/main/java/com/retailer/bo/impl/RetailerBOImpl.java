package com.retailer.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailer.bo.RetailerBO;
import com.retailer.dao.DiscountDAO;
import com.retailer.entities.DiscountMaster;
import com.retailer.entities.RequestParameters;
import com.retailer.entities.Total;
import com.retailer.utils.RetailerUtils;

@Service
public class RetailerBOImpl implements RetailerBO {

    @Autowired
    private DiscountDAO discountDao;

    @Override
    public Total calculateTotal(RequestParameters requestParams) {
	// TODO Auto-generated method stub
	List<DiscountMaster> totals = discountDao.getApplicableDiscounts(requestParams);
	Total reponse = new Total(0d, requestParams.getPurchaseAmount(), 0d);
	if (!RetailerUtils.isNullOrEmpty(totals)) {
	    Double purchase = requestParams.getPurchaseAmount();
	    Double discountAmount = 0d;
	    for (DiscountMaster discount : totals) {
		Double slab = (discount.getSlabMax() > discount.getSlabMin()
			? discount.getSlabMax() - discount.getSlabMin()
			: discount.getSlabMax());
		purchase = (purchase <= slab ? purchase : purchase - slab);
		Double discAmount = (purchase * discount.getDiscount()) / 100;
		discountAmount = discountAmount + discAmount;
	    }

	    reponse.setAmountOff(discountAmount);
	    reponse.setTotalAfterDiscount(requestParams.getPurchaseAmount() - discountAmount);
	}
	return reponse;
    }

    @Override
    public String addDiscount(RequestParameters requestParams) {
	String response = "New Discount added successfully.";
	requestParams.setPurchaseAmount(requestParams.getMaxSlab());
	List<Double> totals = discountDao.getDiscount(requestParams);
	if (!RetailerUtils.isNullOrEmpty(totals)) {
	    response = "Discount already exists for slab: " + requestParams.getMaxSlab();
	}
	requestParams.setPurchaseAmount(requestParams.getMinSlab());
	totals = discountDao.getDiscount(requestParams);
	if (!RetailerUtils.isNullOrEmpty(totals)) {
	    response = "Discount already exists for slab: " + requestParams.getMinSlab();
	}
	if (!response.contains("already")) {
	    discountDao.addDiscount(requestParams);
	}

	return response;
    }

}
