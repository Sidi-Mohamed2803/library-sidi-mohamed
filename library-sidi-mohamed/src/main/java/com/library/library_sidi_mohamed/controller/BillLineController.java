package com.library.library_sidi_mohamed.controller;

import java.util.Collection;

import com.library.library_sidi_mohamed.domain.Bill;
import com.library.library_sidi_mohamed.domain.BillLine;
import com.library.library_sidi_mohamed.domainManager.BillLineRepository;

import jakarta.ws.rs.Path;

//@Path("/billline")
public class BillLineController {
	
	public static void add(BillLine line, Bill bill) {
		BillLineRepository.save(line, bill);
	}
	
	public static Collection<BillLine> findByBillNumber(String numb) {
		return BillLineRepository.getByBillNumber(numb);
	}
}
