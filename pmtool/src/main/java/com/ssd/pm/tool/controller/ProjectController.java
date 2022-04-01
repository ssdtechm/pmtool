package com.ssd.pm.tool.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.pm.tool.domain.Project;
import com.ssd.pm.tool.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping("/save")
	public ResponseEntity<Project> saveProject(@Valid @RequestBody Project project ,BindingResult result) {

		Project projectResult = projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(projectResult, HttpStatus.CREATED);
	}

}
