package com.retailer.bo;

import com.retailer.entities.RequestParameters;
import com.retailer.entities.Total;

public interface RetailerBO {

    Total calculateTotal(RequestParameters requestParams);

    String addDiscount(RequestParameters requestParams);
}
