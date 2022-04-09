package com.ssd.pm.tool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.pm.tool.domain.Player;
import com.ssd.pm.tool.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public List<Player> findAll() {
		return playerRepository.findAll();
	}

	@Override
	public List<Player> findPlayerByNameStartsWith(String name) {
		return ((PlayerServiceImpl) playerRepository).findPlayerByNameStartsWith(name);
	}

	@Override
	public List<Player> findPlayerByRole(String role) {
		return ((PlayerServiceImpl) playerRepository).findPlayerByRole(role);
	}

	@Override
	public Player save(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public void delete(long playerId) {
		Optional<Player> player1 = playerRepository.findById(playerId);
		playerRepository.deleteAll();
	}
}
