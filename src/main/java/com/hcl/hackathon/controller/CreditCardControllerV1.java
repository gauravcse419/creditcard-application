package com.hcl.hackathon.controller;

import com.hcl.hackathon.model.Customer;
import com.hcl.hackathon.service.CreditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1")
@Tag(name = "Credit", description = "The Credit API")
@RestController
public class CreditCardControllerV1 {
    @Autowired
    CreditService creditService;

    @Operation(summary = "Add a new Credit", description = "", tags = {"Credit"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200, description = Credit created",
                    content = @Content(schema = @Schema(implementation = Customer.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Credit already exists")})
    @PostMapping(value = "/creditcard", consumes = {"application/json", "application/xml"})
    public String createCreditCard(
            @Parameter(description = "Credit to add. Cannot null or empty.",
                    required = true, schema = @Schema(implementation = Customer.class))
            @Valid @RequestBody Customer Customer) {
        return this.creditService.createCreditCard(Customer);
    }
}

