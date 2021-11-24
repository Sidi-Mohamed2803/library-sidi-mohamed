package com.library.library_sidi_mohamed.controller;

import java.time.LocalDate;
import java.util.Collection;

import com.library.library_sidi_mohamed.domain.Client;
import com.library.library_sidi_mohamed.domainManager.ClientRepository;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/client")
public class ClientController {
	
	/*
	 * @POST
	 * 
	 * @Path("/add") public static void add(int id, String fname, String lname,
	 * LocalDate dob) { ClientRepository.save(new Client(id, fname, lname, dob)); }
	 */
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public static Collection<Client> findAll() {
		return ClientRepository.getClients();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static Client findById(@PathParam(value = "id") int id) {	
		return ClientRepository.getById(id);
	}
	
	public static void update(int id, String fname, String lname, LocalDate dob) {
		ClientRepository.edit(id, fname, lname, dob);
	}
	
	@DELETE
	@Path("/{id}")
	public static void remove(@PathParam(value = "id") int id) {
		ClientRepository.delete(id);
	}
}
