package com.library.library_sidi_mohamed.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;

import com.library.library_sidi_mohamed.domainManager.ClientRepository;

public class Client implements Comparable<Client>{
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private int age;
	private static Collection<Client> clients=ClientRepository.getClients();
	
	public Client(int id, String firstName, String lastName, LocalDate dateOfBirth) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.age=Period.between(dateOfBirth, LocalDate.now()).getYears();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

		public int getId() {
		return id;
	}

	public int getAge() {
		return age;
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
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Client o) {
		if(this.id>o.getId())
			return 1;
		if(this.id<o.getId())
			return -1;
		return 0;
	}

	public static Collection<Client> getClients() {
		return clients;
	}

	public static void setClients(Collection<Client> clients) {
		Client.clients = clients;
	}
}
