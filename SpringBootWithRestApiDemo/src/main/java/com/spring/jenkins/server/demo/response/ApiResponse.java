package com.spring.jenkins.server.demo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include. NON_NULL) 
public class ApiResponse {
	private String statusMessage;
	private Integer statusCode;
	private Boolean isSuccess;
	private Object data;

	public ApiResponse(String statusMessage, Integer statusCode, Boolean isSuccess) {
		super();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		this.isSuccess = isSuccess;
	}

}
