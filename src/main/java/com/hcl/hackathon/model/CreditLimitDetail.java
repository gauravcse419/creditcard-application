package com.hcl.hackathon.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class CreditLimitDetail   {
  private String name = null;
  private String panCard = null;

  private Integer cibilLimit = null;

  public CreditLimitDetail name(String name) {
    this.name = name;
    return this;
  }

}

