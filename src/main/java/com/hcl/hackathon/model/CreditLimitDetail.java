package com.hcl.hackathon.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CreditLimitDetail
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-10T10:21:27.147Z")


public class CreditLimitDetail   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("panCard")
  private String panCard = null;

  @JsonProperty("cibilLimit")
  private Integer cibilLimit = null;

  public CreditLimitDetail name(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreditLimitDetail panCard(String panCard) {
    this.panCard = panCard;
    return this;
  }


  public String getPanCard() {
    return panCard;
  }

  public void setPanCard(String panCard) {
    this.panCard = panCard;
  }

  public CreditLimitDetail cibilLimit(Integer cibilLimit) {
    this.cibilLimit = cibilLimit;
    return this;
  }


  public Integer getCibilLimit() {
    return cibilLimit;
  }

  public void setCibilLimit(Integer cibilLimit) {
    this.cibilLimit = cibilLimit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditLimitDetail creditLimitDetail = (CreditLimitDetail) o;
    return Objects.equals(this.name, creditLimitDetail.name) &&
        Objects.equals(this.panCard, creditLimitDetail.panCard) &&
        Objects.equals(this.cibilLimit, creditLimitDetail.cibilLimit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, panCard, cibilLimit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditLimitDetail {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    panCard: ").append(toIndentedString(panCard)).append("\n");
    sb.append("    cibilLimit: ").append(toIndentedString(cibilLimit)).append("\n");
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

