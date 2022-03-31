package com.ssd.pm.tool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.pm.tool.domain.IplTeam;
import com.ssd.pm.tool.service.IplTeamService;

@RestController
@RequestMapping("/ipl/team")
public class IplTeamController {

	@Autowired
	private IplTeamService iplTeamService;
	
	@PostMapping("/save")
	public 	ResponseEntity<IplTeam> saveIplTeamDetails(@RequestBody IplTeam iplTeam, BindingResult result){
		IplTeam teamdDetails = iplTeamService.saveTeamDetails(iplTeam);
		return new ResponseEntity<IplTeam>(teamdDetails,HttpStatus.CREATED);
	}
	@GetMapping(value="/get")
	public ResponseEntity<List<IplTeam>> getAllDetails(){
		List<IplTeam> team = iplTeamService.getTeamDetails( );
		return new ResponseEntity<>(team , HttpStatus.OK);
	}
}
