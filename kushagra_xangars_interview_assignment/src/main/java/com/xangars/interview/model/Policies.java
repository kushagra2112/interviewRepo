package com.xangars.interview.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "Policies")
public class Policies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Product_ID")
	private int productID;

	@Column(name = "Product_Name")
	private String productName;

	@Column(name = "Product_Details")
	private String productDetails;

	@Column(name = "Product_Launch_Date")
	private Date productLaunchDate;

	@Column(name = "Product_End_Date")
	private Date productEndDate;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public Date getProductLaunchDate() {
		return productLaunchDate;
	}

	public void setProductLaunchDate(Date productLaunchDate) {
		this.productLaunchDate = productLaunchDate;
	}

	public Date getProductEndDate() {
		return productEndDate;
	}

	public void setProductEndDate(Date productEndDate) {
		this.productEndDate = productEndDate;
	}

	@Override
	public String toString() {
		return "table1 [productID=" + productID + ", productName=" + productName + ", productDetails=" + productDetails
				+ ", productLaunchDate=" + productLaunchDate + ", productEndDate=" + productEndDate + "]";
	}
	
}
	