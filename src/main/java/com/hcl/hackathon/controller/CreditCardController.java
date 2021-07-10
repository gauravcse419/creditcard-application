package com.hcl.hackathon.controller;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.model.CibilScoreDetail;
import com.hcl.hackathon.model.CreditLimitDetail;
import com.hcl.hackathon.model.Customer;
import com.hcl.hackathon.model.CustomerDetail;

/**
 * 
 * @author lakshmipathi.palla
 * @author Kuldeep Gouranna
 *
 */

public interface CreditCardController {

	/**
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/api/v1/creditcard", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<CustomerDetail> addCustome(@Valid @RequestBody Customer customer);

	/**
	 * 
	 * @param applicationId
	 * @return
	 */
	@RequestMapping(value = "/api/v1/creditcard/applications/{applicationId}", produces = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<CustomerDetail> applicationId(@PathVariable("applicationId") Long applicationId);

	/**
	 * <p>Get application status by passing applicationId id</p>
	 * 
	 * @param applicationId
	 * @return CustomerDetail
	 */
	@Operation(summary = "Get application status by passing id", description = "Returns status of application", tags = { "creditcard" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					content = @Content(schema = @Schema(implementation = CustomerDetail.class))),
			@ApiResponse(responseCode = "404", description = "data not found") })
	@RequestMapping(value = "/api/v1/creditcard/application/{applicationId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CustomerDetail> getApplicationStatus(@PathVariable("applicationId") Long applicationId);


}
