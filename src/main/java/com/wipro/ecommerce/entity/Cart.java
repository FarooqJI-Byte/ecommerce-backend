package com.wipro.ecommerce.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double totalAmount;
	@CreationTimestamp
	private LocalDate dateAdded;

	public Cart() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Cart(int id, double totalAmount, LocalDate dateAdded) {
		super();
		this.id = id;
		this.totalAmount = totalAmount;
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", totalAmount=" + totalAmount + ", dateAdded=" + dateAdded + "]";
	}

}
