package com.retailer.controller;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.bo.RetailerBO;
import com.retailer.constants.ResponseContstants;
import com.retailer.entities.RequestParameters;
import com.retailer.entities.Total;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/billresource")
@Api(value = "BillResource", description = "Operations pertaining Billing/Purchases")
public class BillResource {

    @Autowired
    private RetailerBO retailerBo;

    @GetMapping(value = "/gettotal", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "This API gets the final total after applying the discounts if any on the purchase amount being passed. ")
    @ApiResponses(value = {
	    @ApiResponse(code = ResponseContstants.HTTP_STATUS_OK, message = "Customer upserted.", response = Total.class), })
    @ResponseBody
    ResponseEntity<Total> getTotal(
	    @ApiParam(required = true, name = HeaderConstants.CUSTOMERTYPE, value = "Customer Type - possible value Regular...") @RequestHeader(value = HeaderConstants.CUSTOMERTYPE, defaultValue = "Regular") String customerType,
	    @ApiParam(required = true, name = HeaderConstants.PURCHASE_AMOUNT, value = "Total Purchase Amount") @RequestHeader(HeaderConstants.PURCHASE_AMOUNT) Double purchaseAmount)
	    throws NamingException, SQLException {
	return new ResponseEntity<Total>(retailerBo.calculateTotal(new RequestParameters(customerType, purchaseAmount)),
		HttpStatus.OK);
    }

    @PostMapping(value = "/postdiscount", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "This API adds new discounts. ")
    @ApiResponses(value = {
	    @ApiResponse(code = ResponseContstants.HTTP_STATUS_OK, message = "Customer upserted.", response = String.class), })
    @ResponseBody
    ResponseEntity<String> postDiscount(
	    @ApiParam(required = true, name = HeaderConstants.DISCOUNT, value = "Total Discount in %") @RequestHeader(HeaderConstants.DISCOUNT) Double discount,
	    @ApiParam(required = true, name = HeaderConstants.MINSLAB, value = "Min Slab for the discount") @RequestHeader(HeaderConstants.MINSLAB) Double minSlab,
	    @ApiParam(required = true, name = HeaderConstants.MAXSLAB, value = "Max Slab for the discount if set zero it will be considered as above any value without limt.") @RequestHeader(HeaderConstants.MAXSLAB) Double maxSlab)
	    throws NamingException, SQLException

    {
	return new ResponseEntity<String>(retailerBo.addDiscount(new RequestParameters(discount, maxSlab, minSlab)),
		HttpStatus.OK);
    }

}
