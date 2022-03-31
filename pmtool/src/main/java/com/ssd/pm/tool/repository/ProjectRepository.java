package com.ssd.pm.tool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssd.pm.tool.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	public Optional<Project> findById(Long id);
	public  List<Project> findAll();
	public void deleteById(Long id);
		
	

}
