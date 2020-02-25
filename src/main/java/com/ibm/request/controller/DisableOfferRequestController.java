
package com.ibm.request.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ibm.request.RequestConstants;
import com.ibm.request.model.DisableOffer;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This rest controller handles the restful service calls for handling
 * complaints from users.
 * 
 * @author SowjanyaLakkaraju
 *
 */
@RestController
@CrossOrigin
public class DisableOfferRequestController {

	private ResponseEntity responseEntity;
	private Map<String, String> map = new HashMap<>();
	private static final Logger logger = LoggerFactory.getLogger(DisableOfferRequestController.class);


	private static final String USER_SERVICE_URL = "http://user-service2-marketingoffersadmin.192.168.99.118.nip.io/api/v1/user/disableOffer";
	@Autowired
	private RestTemplate restTemplate;

	
	public DisableOfferRequestController() {
		// TODO Auto-generated constructor stub
	}

	@ApiOperation(value = "Disables the offer for an user", tags = "Disable Offer for user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success | Created"),
			@ApiResponse(code = 401, message = "Un Authorized"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "Resource Not Found"), @ApiResponse(code = 409, message = "Conflict"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PostMapping(path = "/api/v1/disableOffer")
	public ResponseEntity<?> disableOfferRequest(@RequestBody DisableOffer inputObj) {
		
		try {
		HttpEntity<DisableOffer> requestEntity = new HttpEntity<>(inputObj);
		
		String response = restTemplate.postForObject(USER_SERVICE_URL, requestEntity,String.class);
		
		if (null != response && !response.isEmpty()) {
			responseEntity = new ResponseEntity<>(RequestConstants.SUCCESS, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<>(RequestConstants.FAILURE, HttpStatus.CONFLICT);
		}
		}catch(Exception e) {
			logger.error("Exception occurred in disableOfferController",e);
			responseEntity = new ResponseEntity<>(RequestConstants.FAILURE, HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	
}
