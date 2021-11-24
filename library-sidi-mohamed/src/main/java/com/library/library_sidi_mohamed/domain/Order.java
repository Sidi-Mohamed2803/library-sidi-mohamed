package com.library.library_sidi_mohamed.domain;

import java.time.LocalDate;
import java.util.Collection;

public class Order implements Comparable<Order> {
	private int number,quantity;
	private LocalDate date;
	private Book book;
	private Client client;
	private static Collection<Order> orders;
	
	public Order() {
	}

	public Order(int quantity, LocalDate date, Book book, Client client) {
		this.quantity = quantity;
		this.date = date;
		this.book = book;
		this.client = client;
	}

	public Order(int number, int quantity, LocalDate date, Book book, Client client) {
		this.number = number;
		this.quantity = quantity;
		this.date = date;
		this.book = book;
		this.client = client;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static Collection<Order> getOrders() {
		return orders;
	}

	public static void setOrders(Collection<Order> orders) {
		Order.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [number=" + number + ", quantity=" + quantity + ", date=" + date + ", book=" + book + ", client="
				+ client + "]";
	}

	@Override
	public int compareTo(Order o) {
		if(this.number>o.number)
			return 1;
		if(this.number<o.number)
			return -1;
		return 0;
	}
	
}
