package com.hcl.hackathon.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;



public class CibilScoreDetail   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("panCard")
  private String panCard = null;

  @JsonProperty("cibilScore")
  private Integer cibilScore = null;

  public CibilScoreDetail name(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CibilScoreDetail panCard(String panCard) {
    this.panCard = panCard;
    return this;
  }


  public String getPanCard() {
    return panCard;
  }

  public void setPanCard(String panCard) {
    this.panCard = panCard;
  }

  public CibilScoreDetail cibilScore(Integer cibilScore) {
    this.cibilScore = cibilScore;
    return this;
  }

  public Integer getCibilScore() {
    return cibilScore;
  }

  public void setCibilScore(Integer cibilScore) {
    this.cibilScore = cibilScore;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CibilScoreDetail cibilScoreDetail = (CibilScoreDetail) o;
    return Objects.equals(this.name, cibilScoreDetail.name) &&
        Objects.equals(this.panCard, cibilScoreDetail.panCard) &&
        Objects.equals(this.cibilScore, cibilScoreDetail.cibilScore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, panCard, cibilScore);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CibilScoreDetail {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    panCard: ").append(toIndentedString(panCard)).append("\n");
    sb.append("    cibilScore: ").append(toIndentedString(cibilScore)).append("\n");
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

