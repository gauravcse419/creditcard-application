package com.hcl.hackathon.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the application_details database table.
 * 
 */
@Entity
@Table(name="application_details")
@NamedQuery(name="ApplicationDetail.findAll", query="SELECT a FROM ApplicationDetail a")
public class ApplicationDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="application_no")
	private Integer applicationNo;

	@Column(name="card_type")
	private String cardType;

	@Column(name="credit_limit")
	private double creditLimit;

	private String status;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public ApplicationDetail() {
	}

	public Integer getApplicationNo() {
		return this.applicationNo;
	}

	public void setApplicationNo(Integer applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public double getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}