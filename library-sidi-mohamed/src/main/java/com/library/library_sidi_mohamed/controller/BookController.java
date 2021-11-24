package com.library.library_sidi_mohamed.controller;

import java.util.Collection;

import com.library.library_sidi_mohamed.domain.Book;
import com.library.library_sidi_mohamed.domainManager.BookRepositotry;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/book")
public class BookController {
	
	@POST
	public static void add(Book book) {
		BookRepositotry.save(book);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public static Collection<Book> findAll()
	{
		return BookRepositotry.getAll();
	}
	
	@GET
	@Path("/{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	public static Book findByIsbn(@PathParam(value = "isbn") long isbn)
	{
		return BookRepositotry.getByIsbn(isbn);
	}
	
	@DELETE
	@Path("/{isbn}")
	public static void remove(@QueryParam(value = "isbn") long isbn)
	{
		BookRepositotry.delete(isbn);
	}
}
