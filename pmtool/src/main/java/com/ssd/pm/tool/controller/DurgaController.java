package com.ssd.pm.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.pm.tool.domain.Durga;
import com.ssd.pm.tool.service.DurgaService;

@RestController
@RequestMapping("/durga")
public class DurgaController {

	@Autowired
	private DurgaService durgaService;

	
	@PostMapping("/save")
	public ResponseEntity<Durga> saveDetails(@RequestBody Durga durga) {

		Durga dSave = durgaService.saveOrUpdate(durga);

		return new ResponseEntity<Durga>(dSave, HttpStatus.CREATED);

	}

}
