package com.ssd.pm.tool.Exception;

public class PlayerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2957645951463009211L;

	public PlayerNotFoundException(String message) {
		super(message);
	}
}
