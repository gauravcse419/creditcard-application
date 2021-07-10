package com.hcl.hackathon.controller;

import javax.validation.Valid;

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
 *
 */
@RestController
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
	 * 
	 * @param applicationId
	 * @return
	 */
	@RequestMapping(value = "/api/v1/creditcard/application/{applicationId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CustomerDetail> getApplicationStatus(@PathVariable("applicationId") Long applicationId);

	/**
	 * 
	 * @param pancardno
	 * @return
	 */
	@RequestMapping(value = "/api/v1/cibilscore/{pancardno}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CibilScoreDetail> getCibilByPancardNo(@PathVariable("pancardno") String pancardno);

	/**
	 * 
	 * @param pancardNo
	 * @return
	 */
	@RequestMapping(value = "/api/v1/creditlimit/{pancardNo}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CreditLimitDetail> pancardNo(@PathVariable("pancardNo") Long pancardNo);

}
