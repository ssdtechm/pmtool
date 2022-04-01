package com.ssd.pm.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssd.pm.tool.domain.Durga;

@Repository
public interface DurgaRepos  extends  JpaRepository<Durga, Long>{
	

}
