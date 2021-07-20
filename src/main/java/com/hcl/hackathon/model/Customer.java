package com.hcl.hackathon.model;
import com.sun.istack.internal.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Customer
 */

@Data
public class Customer   {
  @Schema(description = "name",
          example = "name", required = false)
  private String name = null;

  @Schema(description = "dob",
          example = "12-04-1989", required = false)
  private String dob = null;

  @Schema(description = "phoneNo",
          example = "12345555", required = false)
  private Integer phoneNo = null;

  @Schema(description = "emailId",
          example = "test@gmail.com", required = false)
  private String emailId = null;

  @NotEmpty
  private String pancard = null;

  @Schema(description = "annualSalary",
          example = "100000.0", required = false)
  private Double annualSalary = null;

  @Schema(description = "address",
          example = "Hyderabad", required = false)
  private String address = null;

}

