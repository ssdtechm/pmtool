package com.ssd.pm.tool.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class IplTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;
	@NotBlank(message = "The Team Name mustin should be Given")
	private String teamName;
	@NotBlank(message = "The Captian Name mustin should be Given")
	private String teamCaptian;
	@NotBlank(message = "The Team Belong's to the State Name should be Given")
	private String teamState;
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamCaptian() {
		return teamCaptian;
	}
	public void setTeamCaptian(String teamCaptian) {
		this.teamCaptian = teamCaptian;
	}
	public String getTeamState() {
		return teamState;
	}
	public void setTeamState(String teamState) {
		this.teamState = teamState;
	}
	
	
}

