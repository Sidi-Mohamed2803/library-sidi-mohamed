package com.library.library_sidi_mohamed.domainManager;

import java.sql.*;

import oracle.jdbc.OracleDriver;

public class SConnection
{
	private static String url="jdbc:oracle:thin:@//localhost:1521/XE";
	private static String user="librarySidi";
	private static String mdp="librarySidi";
	private static Connection cnx =null;
	
	public static Connection getInstance() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			cnx = DriverManager.getConnection(url, user, mdp);
			//System.out.println("Connexion réussie!\n");
		} catch (SQLException e) {
			System.out.println("Problème rencontré lors de la connexion...\n");
			e.printStackTrace();
		}
		return cnx;
	}
	
	public static void close() {
		try {
			cnx.close();
			//System.out.println("Connexion fermée avec succès!\n");
		} catch (SQLException e) {
			System.out.println("Problème rencontré lors de la fermeture de la connexion...\n");
			e.printStackTrace();
		}
	}
}
