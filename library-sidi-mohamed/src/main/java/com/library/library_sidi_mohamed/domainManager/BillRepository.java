package com.library.library_sidi_mohamed.domainManager;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.library.library_sidi_mohamed.domain.Bill;
import com.library.library_sidi_mohamed.domain.BillLine;

public class BillRepository {
	public static void save(Bill bill) {
		Connection cnx=SConnection.getInstance();
		try {
			String request = "insert into bill values (?,?,?,1";
			PreparedStatement pstmt = cnx.prepareStatement(request);
			pstmt.setString(1, bill.getBillNumber());
			pstmt.setInt(2, bill.getClient().getId());
			pstmt.setDate(3, Date.valueOf(bill.getDate()));
			if(pstmt.executeUpdate()==1)
			{
				for (BillLine line : bill.getLines()) {
					BillLineRepository.save(line, bill);
				}
				System.out.println("La facture "+bill.getBillNumber()+" a �t� ajout�e avec succ�s.");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			SConnection.close();
		}
	}
}
