package com.consume.rest.api.service;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.consume.rest.api.filereader.PropertyFileValue;
import com.consume.rest.api.models.Book;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class BookService {
	private static final Logger LOGGER = Logger.getLogger(BookService.class);

	public static Response addBook(Book book) throws IOException {
		LOGGER.info("====>>> Going to addBook() method of BookService class : " + book);
		Gson gson = new Gson();
		String bookJsonData = gson.toJson(book);
		LOGGER.info("====>>> Going to addBook() method of BookService class : " + bookJsonData);
		// Post Request Using OKHttpClient in Java
		OkHttpClient client = new OkHttpClient();
		RequestBody body = RequestBody.create(MediaType.parse("application/json"), bookJsonData);
		Request request = new Request.Builder().url(PropertyFileValue.ADD_BOOK).post(body).build();
		Call call = client.newCall(request);
		Response response = call.execute();
		LOGGER.info("====>>> Going to addBook() method of BookService class Response : " + response);
		return response;
	}

	public static Response getAllBooks() throws IOException {
		// GET Request Using OKHttpClient in Java
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(PropertyFileValue.GET_BOOKS).get().build();
		Response response = client.newCall(request).execute();
		LOGGER.info("====>>> Going to getAllBooks() method of BookService class Response : " + response);
		return response;
	}

	public static Response getBook(int id) throws IOException {
		LOGGER.info("====>>> Going to getBook() method of BookService class : id [" + id + "]");
		// GET Request Using OKHttpClient in Java
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(PropertyFileValue.GET_BOOK + "/" + id).get().build();
		Response response = client.newCall(request).execute();
		LOGGER.info("====>>> Going to getBook() method of BookService class Response : " + response);
		return response;
	}

	public static Response deleteBook(int id) throws IOException {
		LOGGER.info("====>>> Going to deleteBook() method of BookService class : id [" + id + "]");
		// DELETE Request Using OKHttpClient in Java
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(PropertyFileValue.DELETE_BOOK + "/" + id).delete().build();
		Response response = client.newCall(request).execute();
		LOGGER.info("====>>> Going to deleteBook() method of BookService class Response : " + response);
		return response;
	}

	public static Response updateBook(int id, Book book) throws IOException {
		LOGGER.info("====>>> Going to updateBook() method of BookService class : " + book + " id : [" + id + "]");
		Gson gson = new Gson();
		String bookJsonData = gson.toJson(book);
		LOGGER.info("====>>> Going to updateBook() method of BookService class : " + bookJsonData);
		// PUT Request Using OKHttpClient in Java
		OkHttpClient client = new OkHttpClient();
		RequestBody body = RequestBody.create(MediaType.parse("application/json"), bookJsonData);
		Request request = new Request.Builder().url(PropertyFileValue.UPDATE_BOOK + "/" + id).put(body).build();
		Response response = client.newCall(request).execute();
		LOGGER.info("====>>> Going to updateBook() method of BookService class Response : " + response);
		return response;
	}

}
