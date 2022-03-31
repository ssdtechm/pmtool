package com.ssd.pm.tool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException{
	
	public ProjectIdException(String excetionMsg) {
		super(excetionMsg);
	}

}
