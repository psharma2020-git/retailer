package com.retailer;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.retailer.entities.Total;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RetailerApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testForNoDiscount() {

	HttpHeaders headers = new HttpHeaders();
	headers.set("purchaseamount", "5000");

	HttpEntity<Total> requestEntity = new HttpEntity<>(null, headers);

	ResponseEntity<Total> responseEntity = restTemplate.exchange("/billresource/gettotal", HttpMethod.GET,
		requestEntity, Total.class);

	Assert.state(responseEntity.getStatusCodeValue() == 200, "Expected status 200 OK");
	Assert.state(responseEntity.getBody().getAmountOff() == 0, "No discount is expected for purchase upto 5000");

    }

    @Test
    public void Test10PercentDiscount() {

	HttpHeaders headers = new HttpHeaders();
	headers.set("purchaseamount", "10000");

	HttpEntity<Total> requestEntity = new HttpEntity<>(null, headers);

	ResponseEntity<Total> responseEntity = restTemplate.exchange("/billresource/gettotal", HttpMethod.GET,
		requestEntity, Total.class);

	Assert.isTrue(responseEntity.getStatusCodeValue() == 200, "Expected status 200 OK");
	Assert.state(responseEntity.getBody().getTotalAfterDiscount() == 9500,
		"9500 is expected amount with dicount of 10% on purchase of 10000");

    }

    @Test
    public void Test20PercentDiscount() {

	HttpHeaders headers = new HttpHeaders();
	headers.set("purchaseamount", "15000");

	HttpEntity<Total> requestEntity = new HttpEntity<>(null, headers);

	ResponseEntity<Total> responseEntity = restTemplate.exchange("/billresource/gettotal", HttpMethod.GET,
		requestEntity, Total.class);

	Assert.isTrue(responseEntity.getStatusCodeValue() == 200, "Expected status 200 OK");
	Assert.state(responseEntity.getBody().getTotalAfterDiscount() == 13500,
		"13500 is expected amount with dicount of 10% on purchase of 15000");

    }
}
