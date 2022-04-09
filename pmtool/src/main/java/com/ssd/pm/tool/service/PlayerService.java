package com.ssd.pm.tool.service;

import java.util.List;
import java.util.Optional;

import com.ssd.pm.tool.domain.Player;

public interface PlayerService {

	List<Player> findPlayerByNameStartsWith(String name);

	List<Player> findPlayerByRole(String role);

	List<Player> findAll();

	Player save(Player player);

	void delete(long playerId);

}
