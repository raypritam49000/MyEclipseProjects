package com.telemune.changing.sdp.api;

import java.io.IOException;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class App {
	public static void main(String[] args) throws IOException {
		
		String URL = "https://jsonplaceholder.typicode.com/todos/";

		// Get Request Using OKHttpClient in Java
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(URL).build();
		Response response = client.newCall(request).execute();
		System.out.println(response.body().string());
		System.out.println(response.isSuccessful());
		System.out.println(response.message());

		// Post Request Using OKHttpClient in Java
		OkHttpClient client1 = new OkHttpClient();
		String json = "{\r\n"
				+ "    \"userId\": 400,\r\n"
				+ "    \"title\": \"Pritam Ray\",\r\n"
				+ "    \"completed\": true\r\n"
				+ "  }";
		RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
		Request request1 = new Request.Builder().url(URL).post(body).build();
		Call call1 = client1.newCall(request1);
		Response response1 = call1.execute();
		System.out.println(response1.body().string());
		
		
	}
}
