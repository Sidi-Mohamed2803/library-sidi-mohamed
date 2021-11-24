package com.library.library_sidi_mohamed.domainManager;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.TreeSet;

import com.library.library_sidi_mohamed.domain.Bill;
import com.library.library_sidi_mohamed.domain.BillLine;



public class BillLineRepository {
	public static void save(BillLine line, Bill bill)
	{
		if(line!=null)
		{
			Connection cnx=SConnection.getInstance();
			try
			{
				String request="insert into billline (isbn,billnumber,quantity,amount,state) values (?,?,?,?,1)";
				PreparedStatement pstmt=cnx.prepareStatement(request);
				pstmt.setLong(1, line.getBook().getIsbn());
				pstmt.setString(2, bill.getBillNumber());
				pstmt.setInt(3, line.getQuantity());
				pstmt.setDouble(4, line.getPrice());
				if(pstmt.executeUpdate()==1)
				{
					System.out.println("Ligne ajout�e.");
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				SConnection.close();
			}
		}
	}
	
	public static Collection<BillLine> getByBillNumber(String billNumber)
	{
		Collection<BillLine> lines = new TreeSet<BillLine>();
		Connection cnx = SConnection.getInstance();
		try
		{
			String request="select * from billline where billnumber=?";
			PreparedStatement pstmt = cnx.prepareStatement(request);
			pstmt.setString(1, billNumber);
			ResultSet set = pstmt.executeQuery();
			while (set.next()) {
				lines.add(new BillLine(set.getInt("quantity"), set.getDouble("amount"), BookRepositotry.getByIsbn(set.getLong("isbn"))));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			SConnection.close();
		}
		return lines;
	}
}
