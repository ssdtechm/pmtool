package com.ssd.pm.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssd.pm.tool.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	/*
	 * List<Player> findPlayerByNameStartsWith(String name);
	 * 
	 * List<Player> findPlayerByRole(String role);
	 * 
	 * List<Player> findAll();
	 * 
	 * void delete(Optional<Player> player1);
	 * 
	 */
}
