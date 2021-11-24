package com.library.library_sidi_mohamed.controller;

import java.util.Collection;

import com.library.library_sidi_mohamed.domain.Supplier;
import com.library.library_sidi_mohamed.domainManager.SupplierRepository;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/supplier")
public class SupplierController {
	
	@GET
	@Path("/{id: [0-9]{5}}")
	@Produces(MediaType.APPLICATION_JSON)
	public static Supplier findById(@PathParam(value = "id") int id)
	{
		return SupplierRepository.getById(id);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public static Collection<Supplier> findAll() {
		return SupplierRepository.getSuppliers();
	}
	
	@POST
	@Path("/add")
	public static void add(@FormParam(value = "id") int id, @FormParam(value = "adress") String adress, @FormParam(value = "name") String name, @FormParam(value = "phone") int phone) {
		SupplierRepository.save(new Supplier(id, name, adress, phone));
	}
	
	@DELETE
	@Path("remove/{id}")
	public static void remove(@PathParam(value = "id") int id) {
		SupplierRepository.delete(id);
	}
	
	@PUT
	@Path("edit/{id}")
	public static void update(@PathParam(value = "id") int id, @QueryParam(value = "adress") String adress, @QueryParam(value = "name") String name, @QueryParam(value = "phone") int phone)
	{
		Supplier supplier=SupplierController.findById(id);
		if(adress!=null)
			supplier.setAdress(adress);
		if(name!=null)
			supplier.setName(name);
		if(phone!=0)
			supplier.setPhoneNumb(phone);
		SupplierRepository.update(supplier);
	}
}
