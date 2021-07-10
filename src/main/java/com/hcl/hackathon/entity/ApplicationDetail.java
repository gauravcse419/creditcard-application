package com.hcl.hackathon.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * The persistent class for the application_details database table.
 * 
 */
@Entity
@Table(name="application_details")
@NamedQuery(name="ApplicationDetail.findAll", query="SELECT a FROM ApplicationDetail a")
@Data
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

	private Date creationDate;

	private String status;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

}