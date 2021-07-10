package com.hcl.hackathon.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
@Data
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_id")
	private Integer customerId;

	private String address;

	@Column(name="customer_name")
	private String customerName;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Column(name="email_id")
	private String emailId;


	private String pancard;

	@Column(name="phone_no")
	private String phoneNo;

	private double salary;

	//bi-directional many-to-one association to ApplicationDetail
	@OneToMany(mappedBy="customer")
	private List<ApplicationDetail> applicationDetails;

	public Customer() {
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPancard() {
		return this.pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<ApplicationDetail> getApplicationDetails() {
		return this.applicationDetails;
	}

	public void setApplicationDetails(List<ApplicationDetail> applicationDetails) {
		this.applicationDetails = applicationDetails;
	}

	public ApplicationDetail addApplicationDetail(ApplicationDetail applicationDetail) {
		getApplicationDetails().add(applicationDetail);
		applicationDetail.setCustomer(this);

		return applicationDetail;
	}

	public ApplicationDetail removeApplicationDetail(ApplicationDetail applicationDetail) {
		getApplicationDetails().remove(applicationDetail);
		applicationDetail.setCustomer(null);

		return applicationDetail;
	}

}