package com.hcl.hackathon.controller;

import com.hcl.hackathon.model.CibilScoreDetail;
import com.hcl.hackathon.model.CreditLimitDetail;
import com.hcl.hackathon.model.Customer;
import com.hcl.hackathon.model.CustomerDetail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 
 * @author Kuldeep Gouranna
 *
 */

public interface CreditLimitController {


	/**
	 * <p>Get credit card limit by passing pancard number</p>
	 *
	 * @param pancardNo
	 * @return Returns credit limit
	 */
	@Operation(summary = "Get credit card limit by passing pancard", description = "Returns credit limit", tags = { "creditlimit" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					content = @Content(schema = @Schema(implementation = CreditLimitDetail.class))),
			@ApiResponse(responseCode = "404", description = "data not found") })
	@RequestMapping(value = "/api/v1/creditlimit/{pancardNo}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CreditLimitDetail> getCreditLimit(@PathVariable("pancardNo") String pancardNo);

}
