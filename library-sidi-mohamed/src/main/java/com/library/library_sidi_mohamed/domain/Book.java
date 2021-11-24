package com.library.library_sidi_mohamed.domain;
import java.time.LocalDate;
import java.util.Collection;


public class Book implements Comparable<Book>{
	private long isbn;
	private String title;
	private String author;
	private LocalDate publicationDate;
	//Les prix sont en euros
	private double purchasePrice;
	private double sellingPrice;
	private int pagesNumber;
	private String type;
	private Supplier supplier;
	private static Collection<Book> books;

	public Book(long isbn, String title, String author, LocalDate publicationDate, double purchasePrice,
			double sellingPrice, int pagesNumber, String type, Supplier supplier) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
		this.pagesNumber = pagesNumber;
		this.type = type;
		this.supplier = supplier;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getPagesNumber() {
		return pagesNumber;
	}

	public void setPagesNumber(int pagesNumber) {
		this.pagesNumber = pagesNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public static Collection<Book> getBooks() {
		return books;
	}

	public static void setBooks(Collection<Book> books) {
		Book.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (isbn ^ (isbn >>> 32));
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
		Book other = (Book) obj;
		if (isbn != other.isbn)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publicationDate=" + publicationDate
				+ ", purchasePrice=" + purchasePrice + ", sellingPrice=" + sellingPrice + ", pagesNumber=" + pagesNumber
				+ ", type=" + type + ", supplier=" + supplier + "]\n";
	}

	@Override
	public int compareTo(Book o) {
		if(this.isbn>o.isbn)
			return 1;
		if(this.isbn<o.isbn)
			return -1;
		return 0;
	}
	
}
