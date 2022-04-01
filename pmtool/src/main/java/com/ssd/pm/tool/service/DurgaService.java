package com.ssd.pm.tool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.pm.tool.domain.Durga;
import com.ssd.pm.tool.repository.DurgaRepos;

@Service
public class DurgaService {

	@Autowired
	private DurgaRepos durgaRepos;
	
	
	public Durga saveOrUpdate(Durga durga) {
		
		return durgaRepos.save(durga);
		
		
	}
	
	
	
	
}
