package com.ssd.pm.tool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ssd.pm.tool.Exception.PlayerNotFoundException;
import com.ssd.pm.tool.domain.Player;

@ControllerAdvice
public class PlayerExceptionController {

	@ExceptionHandler(value = PlayerNotFoundException.class)
	public ResponseEntity<Player> palyerExceptionHandler(PlayerNotFoundException playerNotFoundException) {
		return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
	}
}
