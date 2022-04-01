package com.ssd.pm.tool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.pm.tool.domain.Project;
import com.ssd.pm.tool.service.MapValidationErrorService;
import com.ssd.pm.tool.service.ProjectService;



@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
    @Autowired
    private MapValidationErrorService mapValidationErrorService;


	@PostMapping("/save")
	public ResponseEntity<?> saveProject(@Valid @RequestBody Project project,BindingResult result) {
		
		List<FieldError> validationErrors = result.getFieldErrors();
		Map<String,String> erorMap = new HashMap<String,String>();
		
		for(FieldError error:validationErrors) {
			erorMap.put(error.getField(), error.getDefaultMessage());
		}
		  if(result.hasErrors()) { 
			  return new ResponseEntity<Map<String,String>>(erorMap,HttpStatus. BAD_REQUEST);
			  }
		 
		
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
	            // throw  new  ProjectIdException("Cannot Project with ID '"+id+"'. This project does not exist",HttpStatus.INTERNAL_SERVER_ERROR);
	        }

		}
		return null;
		
	}
}
