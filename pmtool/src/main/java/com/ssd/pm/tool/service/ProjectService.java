package com.ssd.pm.tool.service;

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
}
