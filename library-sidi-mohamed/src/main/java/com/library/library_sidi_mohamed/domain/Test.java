package com.library.library_sidi_mohamed.domain;

import com.library.library_sidi_mohamed.controller.BookController;

public class Test {

	public static void main(String[] args) {
		System.out.println("Yo");
		System.out.println(BookController.findAll()); 
		//Supplier supplier=new Supplier(1, "Kana", "Bruxelles", 22222222);
		//SupplierRepository.save(supplier);
		//BookController.add(new Book(9782505060833L, "Naruto - Tome 63", "Masashi Kishimoto", LocalDate.of(2014, 7, 3), 6.85, 7, 192, "Manga", supplier));
	}
}
