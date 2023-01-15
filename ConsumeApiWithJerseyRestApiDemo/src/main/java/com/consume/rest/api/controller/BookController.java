package com.consume.rest.api.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.consume.rest.api.models.Book;
import com.consume.rest.api.service.BookService;
import com.google.gson.Gson;

@Path("/books")
public class BookController {
	private static final Logger LOGGER = Logger.getLogger(BookController.class);

	@GET
	@Path("/hello")
	public String hello() {
		LOGGER.info("====>>> Hello World");
		return "Hello";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBook(Book book) {
		LOGGER.info("====>>> Going to addBook() method of BookController class : " + book);
		try {
			if (book == null || book.getTitle() == null || book.getTitle().equals("") || book.getUserId() == null
					|| book.getUserId().equals("") || book.getCompleted().equals("") || book.getCompleted() == null) {

				Map<?, ?> map = Map.of("statusCode", 400, "message", "All parameter are required", "success", false);
				LOGGER.error("====>>> Going to addBook() method of Book Controller class : " + map);

				return Response.status(Response.Status.BAD_REQUEST).entity(map).build();
			} else {
				com.squareup.okhttp.Response response = BookService.addBook(book);

				Map<?, ?> map = Map.of("statusCode", response.code(), "isSuccess", response.isSuccessful(), "message",
						response.message(), "body", new Gson().fromJson(response.body().string(), Book.class));

				LOGGER.info("====>>> Exit to addBook() method of BookController class : " + map);

				return Response.status(Response.Status.CREATED).entity(map).build();
			}
		} catch (Exception e) {

			e.printStackTrace();
			Map<?, ?> map = Map.of("statusCode", 501, "success", true, "message", e.getMessage());
			LOGGER.error("====>>> Going to CatchBlock addBook() method of BookController class : " + map);

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(map).build();
		}

	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBooks() {
		try {
			com.squareup.okhttp.Response response = BookService.getAllBooks();
			Gson gson = new Gson();
			List<Book> bookList = gson.fromJson(response.body().string(), List.class);
			LOGGER.info("====>>> Going to getAllBooks() method of BookController class : " + bookList);

			if (bookList != null && !bookList.isEmpty() && bookList.size() > 0) {
				Map<?, ?> map = Map.of("statusCode", response.code(), "isSuccess", response.isSuccessful(), "message",
						response.message(), "body", bookList);

				LOGGER.info("====>>> Going to getAllBooks() method of BookController class : " + map);

				return Response.status(Response.Status.OK).entity(map).build();

			} else {
				Map<?, ?> map = Map.of("statusCode", 404, "message", "Book Data Not Found", "success", false);

				LOGGER.error("====>>> Exit to getAllBooks() method of BookController class : " + map);
				return Response.status(Response.Status.NOT_FOUND).entity(map).build();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Map<?, ?> map = Map.of("statusCode", 501, "success", true, "message", e.getMessage());
			LOGGER.error("====>>> Going to Catch Block getAllBooks() method of BookController class : " + map);

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(map).build();
		}
	}

	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBook(@PathParam("id") int id) {
		try {

			if (id < 0) {
				Map<?, ?> map = Map.of("statusCode", 400, "success", false, "message",
						"Please enter id is greater than 0");
				LOGGER.error("====>>> Going to getBook() method of BookController class : " + map);
				return Response.status(Response.Status.BAD_REQUEST).entity(map).build();
			}

			com.squareup.okhttp.Response response = BookService.getBook(id);
			Gson gson = new Gson();
			Book book = gson.fromJson(response.body().string(), Book.class);
			LOGGER.info("====>>> Going to getBook() method of BookController class : " + book);

			if (book != null && !book.getTitle().equals("") && book.getTitle() != null && !book.getUserId().equals("")
					&& book.getUserId() != null && !book.getCompleted().equals("") && book.getCompleted() != null) {

				Map<?, ?> map = Map.of("statusCode", response.code(), "isSuccess", response.isSuccessful(), "message",
						response.message(), "body", book);

				LOGGER.info("====>>> Exit to getBook() method of BookController class : " + map);

				return Response.status(Response.Status.OK).entity(map).build();

			} else {
				return Response.status(Response.Status.BAD_REQUEST)
						.entity(Map.of("statusCode", 401, "message", "BAD_REQUEST", "success", false)).build();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Map<?, ?> map = Map.of("statusCode", 501, "success", true, "message", e.getMessage());
			LOGGER.error("====>>> Going Catch Block to getBook() method of BookController class : " + map);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(map).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBook(@PathParam("id") int id) {
		try {

			if (id < 0) {
				Map<?, ?> map = Map.of("statusCode", 400, "success", false, "message",
						"Please enter id is greater than 0");
				LOGGER.error("====>>> Going to deleteBook() method of BookController class : " + map);
				return Response.status(Response.Status.BAD_REQUEST).entity(map).build();
			}

			com.squareup.okhttp.Response response = BookService.deleteBook(id);

			if (response.isSuccessful()) {
				Map<?, ?> map = Map.of("statusCode", response.code(), "isSuccess", response.isSuccessful(), "message",
						response.message());
				LOGGER.info("====>>> Going to deleteBook() method of BookController class : " + map);
				return Response.status(Response.Status.OK).entity(map).build();
			} else {
				Map<?, ?> map = Map.of("statusCode", 401, "message", "BAD_REQUEST", "success", false);
				LOGGER.info("====>>> Going to deleteBook() method of BookController class : " + map);
				return Response.status(Response.Status.BAD_REQUEST).entity(map).build();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Map<?, ?> map = Map.of("statusCode", 501, "success", true, "message", e.getMessage());
			LOGGER.error("====>>> Going Catch Block to deleteBook() method of BookController class : " + map);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(map).build();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBook(@PathParam("id") int id, Book book) {
		LOGGER.info("====>>> Going to updateBook() method of BookController class : "+ book+" id : ["+id+"]");
		try {

			if (id < 0) {
				Map<?, ?> map = Map.of("statusCode", 400, "success", false, "message",
						"Please enter id is greater than 0");
				
				LOGGER.error("====>>> Going to updateBook() method of BookController class : " + map);
				
				return Response.status(Response.Status.BAD_REQUEST).entity(map).build();
			}

			if (book == null || book.getTitle() == null || book.getTitle().equals("") || book.getUserId() == null
					|| book.getUserId().equals("") || book.getCompleted().equals("") || book.getCompleted() == null) {

				Map<?, ?> map = Map.of("statusCode", 400, "message", "All parameter are required", "success", false);
				LOGGER.error("====>>> Going to updateBook() method of Book Controller class : " + map);

				return Response.status(Response.Status.BAD_REQUEST).entity(map).build();
				
			} else {
				com.squareup.okhttp.Response response = BookService.updateBook(id, book);

				Map<?, ?> map = Map.of("statusCode", response.code(), "isSuccess", response.isSuccessful(), "message",
						response.message(), "body", new Gson().fromJson(response.body().string(), Book.class));
				LOGGER.info("====>>> Exit to updateBook() method of Book Controller class : " + map);
				
				return Response.status(Response.Status.CREATED).entity(map).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Map<?, ?> map = Map.of("statusCode", 501, "success", true, "message", e.getMessage());
			LOGGER.error("====>>> Going CatchBlock to updateBook() method of BookController class : " + map);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(map).build();
		}

	}

}
