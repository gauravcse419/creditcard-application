package com.hcl.hackathon.entity;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="application_details")
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
	private String panCard;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

}