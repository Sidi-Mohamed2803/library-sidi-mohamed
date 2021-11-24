package com.library.library_sidi_mohamed.domainManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.library.library_sidi_mohamed.domain.Order;


public class OrderRepository {
	public static void save(Order order)
	{
		if(order!=null)
		{
			Connection cnx=SConnection.getInstance();
			try
			{
				String request="insert into t_order (order_number,order_date,quantity,client,book) values (?,?,?,?,?)";
				PreparedStatement pstmt=cnx.prepareStatement(request);
				pstmt.setInt(1, order.getNumber());
				pstmt.setDate(2, Date.valueOf(order.getDate()));
				pstmt.setInt(3, order.getQuantity());
				pstmt.setLong(4, order.getClient().getId());
				pstmt.setLong(5, order.getBook().getIsbn());
				if(pstmt.executeUpdate()==1)
				{
					System.out.println("La commande "+order.getNumber()+" a �t� ajout� avec succ�s.");
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

}
