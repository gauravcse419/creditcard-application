package com.hcl.hackathon.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cibil_score database table.
 * 
 */
@Entity
@Table(name="cibil_score")
@NamedQuery(name="CibilScore.findAll", query="SELECT c FROM CibilScore c")
public class CibilScore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cibil_id")
	private Integer cibilId;

	@Column(name="cibil_score")
	private double cibilScore;

	private String name;

	@Column(name="pancard_no")
	private String pancardNo;

	public CibilScore() {
	}

	public Integer getCibilId() {
		return this.cibilId;
	}

	public void setCibilId(Integer cibilId) {
		this.cibilId = cibilId;
	}

	public double getCibilScore() {
		return this.cibilScore;
	}

	public void setCibilScore(double cibilScore) {
		this.cibilScore = cibilScore;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPancardNo() {
		return this.pancardNo;
	}

	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}

}