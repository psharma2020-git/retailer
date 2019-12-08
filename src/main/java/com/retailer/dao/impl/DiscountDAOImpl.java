package com.retailer.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.retailer.dao.DiscountDAO;
import com.retailer.entities.DiscountMaster;
import com.retailer.entities.RequestParameters;

@Repository
public class DiscountDAOImpl implements DiscountDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Double> getDiscount(RequestParameters requestParams) {
	// TODO Auto-generated method stub
	return jdbcTemplate.query(
		"SELECT discount FROM DiscountMaster WHERE " + requestParams.getPurchaseAmount() + " > slabmin AND "
			+ requestParams.getPurchaseAmount() + " <= slabmax OR slabmax = 0;",
		(rs, rowNum) -> new Double(rs.getDouble("discount")));
    }

    @Override
    public int addDiscount(RequestParameters requestParams) {
	// TODO Auto-generated method stub
	return jdbcTemplate
		.update("INSERT INTO DiscountMaster (slabmin, slabmax, discount) VALUES(" + requestParams.getMinSlab()
			+ ", " + requestParams.getMaxSlab() + ", " + requestParams.getDiscount() + ")");
    }

    @Override
    public List<DiscountMaster> getApplicableDiscounts(RequestParameters requestParams) {
	// TODO Auto-generated method stub
	return jdbcTemplate.query(
		"SELECT * FROM DiscountMaster WHERE " + requestParams.getPurchaseAmount()
			+ " > slabmin ORDER BY slabmin;",
		(rs, rowNum) -> new DiscountMaster(rs.getInt("id"), rs.getDouble("slabmin"), rs.getDouble("slabmax"),
			rs.getDouble("discount")));
    }

}
