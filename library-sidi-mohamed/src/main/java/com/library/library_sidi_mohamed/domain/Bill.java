package com.library.library_sidi_mohamed.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Bill implements Comparable<Bill> {
	private String billNumber;
	private Client client;
	private LocalDate date;
	private Collection<BillLine> lines;
	private static Collection<Bill> todaysBills;

	public Bill(Client client, LocalDate date, ArrayList<BillLine> lines) {
		this.client = client;
		this.date = date;
		this.setLines(lines);
		this.billNumber=this.generateNumber();
	}
	
	public String generateNumber()
	{
		String number=""+this.date;
		int count=todaysBills.size();
		
		if(count>999 && count<9999)
			number+=""+count+1;
		else if(count>99)
			number+="0"+count+1;
		else if(count>9)
			number+="00"+count+1;
		else
			number+="000"+count+1;
		return number;
	}

	public Client getClient() {
		return client;
	}


	public LocalDate getDate() {
		return date;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public Collection<BillLine> getLines() {
		return lines;
	}

	public void setLines(ArrayList<BillLine> lines) {
		this.lines = lines;
	}

	@Override
	public String toString() {
		return "Bill [billNumber=" + billNumber + ", client=" + client + ", date=" + date + ", lines=" + lines + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billNumber == null) ? 0 : billNumber.hashCode());
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
		Bill other = (Bill) obj;
		if (billNumber == null) {
			if (other.billNumber != null)
				return false;
		} else if (!billNumber.equals(other.billNumber))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Bill o) {
		return this.billNumber.compareTo(o.billNumber);
	}
}
