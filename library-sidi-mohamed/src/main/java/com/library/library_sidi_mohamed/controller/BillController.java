package com.library.library_sidi_mohamed.controller;

import com.library.library_sidi_mohamed.domain.Bill;
import com.library.library_sidi_mohamed.domainManager.BillRepository;

import jakarta.ws.rs.Path;


public class BillController {
	
	
	public static void add(Bill bill) {
		BillRepository.save(bill);
	}
}
