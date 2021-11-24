package com.library.library_sidi_mohamed.domainManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collection;
import java.util.TreeSet;

import com.library.library_sidi_mohamed.domain.Client;


public class ClientRepository {
	
	public static void save(Client client)
	{
		if(client!=null)
		{
			Connection cnx=SConnection.getInstance();
			try
			{
				String request="insert into client (fname,lname,dateofbirth) values (?,?,?)";
				PreparedStatement pstmt=cnx.prepareStatement(request);
				pstmt.setString(1, client.getFirstName());
				pstmt.setString(2, client.getLastName());
				Date d =Date.valueOf(client.getDateOfBirth());
				pstmt.setDate(3, d);
				if(pstmt.executeUpdate()==1)
				{
					System.out.println("Le client "+client.getFirstName()+" "+client.getLastName()+" a �t� ajout� avec succ�s.");
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
	
	public static Collection<Client> getClients()
	{
		Collection<Client> clients=new TreeSet<Client>();
		Connection cnx = SConnection.getInstance();
		try
		{
			String request="select * from client";
			Statement stmt = cnx.createStatement();
			ResultSet set = stmt.executeQuery(request);
			while (set.next()) {
				clients.add(new Client(set.getInt("id"), set.getString("fname"), set.getString("lname"), set.getDate("dateofbirth").toLocalDate()));
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
		return clients;
	}
	
	public static Client getById(int id)
	{
		Client client=null;
		Connection cnx=SConnection.getInstance();
		try
		{
			String request="select * from client where id=?";
			PreparedStatement pstmt=cnx.prepareStatement(request);
			pstmt.setInt(1, id);
			ResultSet set = pstmt.executeQuery();
			set.next();
			client = new Client(set.getInt("id"), set.getString("fname"), set.getString("lname"), set.getDate("dateofbirth").toLocalDate());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			SConnection.close();
		}
		return client;
	}
	
	public static void edit(int id, String fname, String lname, LocalDate dateOfBirth)
	{
		Connection cnx=SConnection.getInstance();
		try
		{
			String request="update client set fname=?, lname=?, dateofbirth=? where id=?";
			PreparedStatement pstmt=cnx.prepareStatement(request);
			pstmt.setInt(4, id);
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setDate(3, Date.valueOf(dateOfBirth));
			int n=pstmt.executeUpdate();
			if(n==1)
				System.out.println("Le client "+id+" a �t� modifi� avec succ�s.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			SConnection.close();
		}
	}
	
	public static void delete(int id) {
		Connection cnx=SConnection.getInstance();
		try
		{
			String request="update client set state=0 where id=?";
			PreparedStatement pstmt=cnx.prepareStatement(request);
			pstmt.setInt(1, id);
			int n=pstmt.executeUpdate();
			if(n==1)
				System.out.println("Le client "+id+" a �t� archiv� avec succ�s.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			SConnection.close();
		}
	}
}
