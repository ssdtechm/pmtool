package com.ssd.pm.tool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.pm.tool.domain.Player;
import com.ssd.pm.tool.service.PlayerServiceImpl;

@RestController
public class PlayerController {

	@Autowired
	private PlayerServiceImpl playerService;

	@RequestMapping(value = "/playersave", method = RequestMethod.POST)

	public ResponseEntity<Player> save(@RequestBody Player player, BindingResult result) {

		Player pl = playerService.save(player);

		return new ResponseEntity<Player>(pl, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/listplayer", method = RequestMethod.GET)
	public List<Player> listPlayer() {
		return playerService.findAll();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam("id") long id) {
		playerService.delete(id);
	}

	@RequestMapping(value = "/startWithName/{name}")
	public List<Player> findByName(@PathVariable("name") String name) {
		return playerService.findPlayerByNameStartsWith(name);
	}

	@RequestMapping(value = "/findByRole/{role}")
	public java.util.List<Player> findByRole(@PathVariable("role") String role) {
		return playerService.findPlayerByRole(role);
	}
}
