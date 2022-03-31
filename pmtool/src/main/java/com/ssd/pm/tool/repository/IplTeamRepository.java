package com.ssd.pm.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssd.pm.tool.domain.IplTeam;

@Repository
public interface IplTeamRepository extends JpaRepository<IplTeam, Long> {

}
