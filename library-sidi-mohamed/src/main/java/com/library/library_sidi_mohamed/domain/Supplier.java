package com.library.library_sidi_mohamed.domain;

import java.util.Collection;

import com.library.library_sidi_mohamed.domainManager.SupplierRepository;

public class Supplier implements Comparable<Supplier> {
	private String adress,name;
	private int id,phoneNumb;
	private static Collection<Supplier> suppliers=SupplierRepository.getSuppliers();

	public Supplier(String adress, String name, int phoneNumb) {
		this.adress = adress;
		this.name = name;
		this.phoneNumb = phoneNumb;
	}
	
	public Supplier(int id, String name,  String adress, int phoneNumb) {
		this.adress = adress;
		this.name = name;
		this.id = id;
		this.phoneNumb = phoneNumb;
	}
	
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumb() {
		return phoneNumb;
	}

	public void setPhoneNumb(int phoneNumb) {
		this.phoneNumb = phoneNumb;
	}

	public int getId() {
		return id;
	}

	public static Collection<Supplier> getSuppliers() {
		return suppliers;
	}
	
	@Override
	public String toString() {
		return "Supplier [adress=" + adress + ", name=" + name + ", id=" + id + ", phoneNumb=" + phoneNumb + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Supplier other = (Supplier) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Supplier o) {
		if(this.id>o.getId())
			return 1;
		if(this.id<o.getId())
			return -1;
		return 0;
	}

}
