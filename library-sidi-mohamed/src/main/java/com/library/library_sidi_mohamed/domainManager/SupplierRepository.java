package com.library.library_sidi_mohamed.domainManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.TreeSet;

import com.library.library_sidi_mohamed.domain.Supplier;


public class SupplierRepository {
	
	public static void save(Supplier supplier)
	{
		if(supplier!=null)
		{
			Connection cnx=SConnection.getInstance();
			try
			{
				String request="insert into supplier values (?,?,?,?,1)";
				PreparedStatement pstmt=cnx.prepareStatement(request);
				pstmt.setInt(1, supplier.getId());
				pstmt.setString(2, supplier.getName());
				pstmt.setString(3, supplier.getAdress());
				pstmt.setInt(4, supplier.getPhoneNumb());
				if(pstmt.executeUpdate()==1)
				{
					System.out.println("Le fournisseur "+supplier.getName()+" a été ajouté avec succès.");
				}
			}
			catch (SQLException e) {
				if(e.getErrorCode()==1)
				{
					System.out.println("Le fournisseur avec identifiant '"+supplier.getId()+"' existe déjà.");
				}
				else e.printStackTrace();
			}
			finally {
				SConnection.close();
			}
		}
	}
	
	public static Supplier getById(int id)
	{
		Supplier supplier=null;
		Connection cnx=SConnection.getInstance();
		try
		{
			String request="select * from supplier where id=?";
			PreparedStatement pstmt=cnx.prepareStatement(request);
			pstmt.setInt(1, id);
			ResultSet set = pstmt.executeQuery();
			set.next();
			supplier = new Supplier(set.getInt("id"), set.getString("name"), set.getString("adress"),set.getInt("phone_numb"));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			SConnection.close();
		}
		return supplier;
	}

	public static Collection<Supplier> getSuppliers()
	{
		Collection<Supplier> suppliers=new TreeSet<Supplier>();
		Connection cnx = SConnection.getInstance();
		try
		{
			String request="select * from supplier";
			Statement stmt = cnx.createStatement();
			ResultSet set = stmt.executeQuery(request);
			while (set.next()) {
				suppliers.add(new Supplier(set.getInt("id"), set.getString("name"), set.getString("adress"), set.getInt("phone_numb")));
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
		return suppliers;
	}
	
	public static void delete(int id) {
		Connection cnx=SConnection.getInstance();
		try
		{
			String delete="delete from supplier where id=?";
			//String request="update supplier set state=0 where id=?";
			PreparedStatement pstmt=cnx.prepareStatement(delete);
			pstmt.setInt(1, id);
			int n=pstmt.executeUpdate();
			if(n==1)
			{
				System.out.println("Le fournisseur "+id+" a été supprimé avec succès.");
				//System.out.println("Le fournisseur "+id+" a été archivé avec succès.");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			SConnection.close();
		}
	}
	
	public static void update(Supplier supplier)
	{
		if(supplier!=null)
		{
			Connection cnx=SConnection.getInstance();
			try
			{
				String request="update supplier set name=?, adress=?, phone_numb=? where id=?";
				PreparedStatement pstmt=cnx.prepareStatement(request);
				pstmt.setInt(4, supplier.getId());
				pstmt.setString(1, supplier.getName());
				pstmt.setString(2, supplier.getAdress());
				pstmt.setInt(3, supplier.getPhoneNumb());
				if(pstmt.executeUpdate()==1)
				{
					System.out.println("Le fournisseur "+supplier.getName()+" a été modifié avec succès.");
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
