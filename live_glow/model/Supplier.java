package com.live_glow.model;

import java.util.*;

public class Supplier {
	private int supplier_id;
	private String supplier_name;
	private String company_name;
	private String email;
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(int supplier_id, String supplier_name, String company_name, String email) {
		super();
		this.supplier_id = supplier_id;
		this.supplier_name = supplier_name;
		this.company_name = company_name;
		this.email = email;
	}
	public double getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", supplier_name=" + supplier_name + ", company_name="
				+ company_name + ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(supplier_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		return supplier_id == other.supplier_id;
	}
	
	

}