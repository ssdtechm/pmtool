package com.ssd.pm.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssd.pm.tool.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
