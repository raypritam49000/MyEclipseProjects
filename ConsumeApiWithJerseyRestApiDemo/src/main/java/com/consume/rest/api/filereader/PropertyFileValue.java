package com.consume.rest.api.filereader;

public interface PropertyFileValue {
	public static final String ADD_BOOK = PropertyFileReader.getValue("ADD_BOOK");
	public static final String GET_BOOKS = PropertyFileReader.getValue("GET_BOOKS");
	public static final String GET_BOOK = PropertyFileReader.getValue("GET_BOOK");
	public static final String UPDATE_BOOK = PropertyFileReader.getValue("UPDATE_BOOK");
	public static final String DELETE_BOOK = PropertyFileReader.getValue("DELETE_BOOK");

	public static void main(String[] args) {
		System.out.println(DELETE_BOOK);
		System.out.println(ADD_BOOK);
		System.out.println(GET_BOOKS);
		System.out.println(GET_BOOK);
		System.out.println(UPDATE_BOOK);
	}
}
