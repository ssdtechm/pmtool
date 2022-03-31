package com.ssd.pm.tool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.pm.tool.domain.IplTeam;
import com.ssd.pm.tool.repository.IplTeamRepository;
 

@Service
public class IplTeamService {

	@Autowired
	private IplTeamRepository iplTeamRepository;

	public IplTeam saveTeamDetails(IplTeam iplTeam) {
		return iplTeamRepository.save(iplTeam);
	}
	
	public List<IplTeam> getTeamDetails(){
		return iplTeamRepository.findAll();
	}
}