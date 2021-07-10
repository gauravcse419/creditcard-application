package com.hcl.hackathon.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Customer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-10T10:21:27.147Z")


public class Customer   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("dob")
  private Object dob = null;

  @JsonProperty("phoneNo")
  private Integer phoneNo = null;

  @JsonProperty("emailId")
  private String emailId = null;

  @JsonProperty("pancard")
  private String pancard = null;

  @JsonProperty("annualSalary")
  private Integer annualSalary = null;

  @JsonProperty("address")
  private String address = null;

  public Customer name(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Customer dob(Object dob) {
    this.dob = dob;
    return this;
  }


  public Object getDob() {
    return dob;
  }

  public void setDob(Object dob) {
    this.dob = dob;
  }

  public Customer phoneNo(Integer phoneNo) {
    this.phoneNo = phoneNo;
    return this;
  }


  public Integer getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(Integer phoneNo) {
    this.phoneNo = phoneNo;
  }

  public Customer emailId(String emailId) {
    this.emailId = emailId;
    return this;
  }


  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public Customer pancard(String pancard) {
    this.pancard = pancard;
    return this;
  }


  public String getPancard() {
    return pancard;
  }

  public void setPancard(String pancard) {
    this.pancard = pancard;
  }

  public Customer annualSalary(Integer annualSalary) {
    this.annualSalary = annualSalary;
    return this;
  }

  public Integer getAnnualSalary() {
    return annualSalary;
  }

  public void setAnnualSalary(Integer annualSalary) {
    this.annualSalary = annualSalary;
  }

  public Customer address(String address) {
    this.address = address;
    return this;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.name, customer.name) &&
        Objects.equals(this.dob, customer.dob) &&
        Objects.equals(this.phoneNo, customer.phoneNo) &&
        Objects.equals(this.emailId, customer.emailId) &&
        Objects.equals(this.pancard, customer.pancard) &&
        Objects.equals(this.annualSalary, customer.annualSalary) &&
        Objects.equals(this.address, customer.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, dob, phoneNo, emailId, pancard, annualSalary, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
    sb.append("    phoneNo: ").append(toIndentedString(phoneNo)).append("\n");
    sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
    sb.append("    pancard: ").append(toIndentedString(pancard)).append("\n");
    sb.append("    annualSalary: ").append(toIndentedString(annualSalary)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

