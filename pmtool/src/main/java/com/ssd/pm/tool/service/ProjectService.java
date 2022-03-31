package com.ssd.pm.tool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.pm.tool.domain.Project;
import com.ssd.pm.tool.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdate(Project project) {
		return projectRepository.save(project);
	}
	public Optional<Project> findById(Long id){
		return projectRepository.findById(id);
	}
	
	public List<Project> findAllProjects(){
		return projectRepository.findAll();
	}
	public void deleteProjectById(Long id) {
		projectRepository.deleteById(id);
	}
}
