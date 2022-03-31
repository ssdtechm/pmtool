package com.ssd.pm.tool.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.pm.tool.domain.Project;
import com.ssd.pm.tool.exception.ProjectIdException;
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
	@GetMapping("/{id}")
	public ResponseEntity<Project> findProjectById(@PathVariable Long id){
		
		Project projectResult = projectService.findById(id).get();
		return new ResponseEntity<Project>(projectResult, HttpStatus.OK);
		
	}

	@GetMapping("/all")
	public ResponseEntity<List<Project>> findAllProjects(){
		List<Project> projectList = projectService.findAllProjects();
		return new ResponseEntity<List<Project>>(projectList, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProjectById(@PathVariable Long id){
			Project projectResult = projectService.findById(id).get();
		if(projectResult!=null) {
			projectService.deleteProjectById(id);
			return new ResponseEntity<String>("Project Deleted Succesfully", HttpStatus.OK);
		}else {
			if(projectResult == null){
	             throw  new  ProjectIdException("Cannot Project with ID '"+id+"'. This project does not exist",HttpStatus.INTERNAL_SERVER_ERROR);
	        }

		}
		return null;
		
	}
}
