package com.library.library_sidi_mohamed.domainManager;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.TreeSet;

import com.library.library_sidi_mohamed.domain.Book;
import com.library.library_sidi_mohamed.domain.Supplier;


public class BookRepositotry {
	public static void save(Book book)
	{
		if(book!=null)
		{
			Connection cnx=SConnection.getInstance();
			try
			{
				String request="insert into book values (?,?,?,?,?,?,?,?,?,1)";
				PreparedStatement pstmt=cnx.prepareStatement(request);
				pstmt.setLong(1, book.getIsbn());
				pstmt.setString(2, book.getTitle());
				pstmt.setString(3, book.getAuthor());
				Date d =Date.valueOf(book.getPublicationDate());
				pstmt.setDate(4, d);
				pstmt.setDouble(5, book.getPurchasePrice());
				pstmt.setDouble(6, book.getSellingPrice());
				pstmt.setInt(7, book.getPagesNumber());
				pstmt.setString(8, book.getTitle());
				pstmt.setInt(9, book.getSupplier().getId());
				if(pstmt.executeUpdate()==1)
				{
					System.out.println("Le livre "+book.getIsbn()+" "+book.getTitle()+" a été ajouté avec succès.");
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
	
	public static Book getByIsbn(long isbn)
	{
		Book book=null;
		Connection cnx=SConnection.getInstance();
		try
		{
			String request="select * from book where isbn=?";
			PreparedStatement pstmt=cnx.prepareStatement(request);
			pstmt.setLong(1, isbn);
			ResultSet set=pstmt.executeQuery();
			set.next();
			Supplier supplier=SupplierRepository.getById(set.getInt("supplier"));
			book = new Book(set.getLong("isbn"), set.getString("title"), set.getString("author"), set.getDate("publication_date").toLocalDate(), set.getDouble("purchase_price"), set.getDouble("selling_price"), set.getInt("pages_number"), set.getString("type"), supplier);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			SConnection.close();
		}
		return book;
	}
	
	public static Collection<Book> getAll()
	{
		Collection<Book> books = new TreeSet<Book>();
		Connection cnx=SConnection.getInstance();
		try
		{
			String request="select * from book";
			PreparedStatement pstmt=cnx.prepareStatement(request);
			ResultSet set=pstmt.executeQuery();
			while(set.next())
			{
				Supplier supplier=SupplierRepository.getById(set.getInt("supplier"));
				books.add(new Book(set.getLong("isbn"), set.getString("title"), set.getString("author"), set.getDate("publication_date").toLocalDate(), set.getDouble("purchase_price"), set.getDouble("selling_price"), set.getInt("pages_number"), set.getString("type"), supplier));
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
		return books;
	}
	
	public static void edit(long id)
	{
		
	}
	
	public static void delete(long isbn)
	{
		Connection cnx=SConnection.getInstance();
		try
		{
			String request="update book set state=0 where id=?";
			PreparedStatement pstmt=cnx.prepareStatement(request);
			pstmt.setLong(1, isbn);
			int n=pstmt.executeUpdate();
			if(n==1)
				System.out.println("Le livre "+isbn+" a été archivé avec succès.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			SConnection.close();
		}
	}
}
