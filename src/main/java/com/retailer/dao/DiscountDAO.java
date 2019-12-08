package com.retailer.dao;

import java.util.List;

import com.retailer.entities.DiscountMaster;
import com.retailer.entities.RequestParameters;

public interface DiscountDAO {

    List<Double> getDiscount(RequestParameters requestParams);

    int addDiscount(RequestParameters requestParams);

    List<DiscountMaster> getApplicableDiscounts(RequestParameters requestParams);

}
