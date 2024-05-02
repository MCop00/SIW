package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Videogame;
import it.uniroma3.siw.service.VideogameService;

@Controller
public class VideogameController {
	@Autowired VideogameService videogameService;
	
	@GetMapping("/indexGame")
	public String indexGame() {
		return "indexGame.html";
	}
	@GetMapping("/formNewGame")
	public String formNewGame(Model model) {
		model.addAttribute("game", new Videogame());
		return "formNewGame.html";
	}
	@PostMapping("/games")
	public String newGame(@ModelAttribute("game") Videogame game, Model model) {
		if(!videogameService.existsByTitleAndYear(game.getTitle(), game.getYear())) {
			this.videogameService.save(game);
			model.addAttribute("game", game);
			return "game.html";
		} else {
			model.addAttribute("messaggioErrore", "Questo gioco esiste già");
			return "formNewGame.html";
		}
	}
	@GetMapping("/game/{id}")
	public String getGame(@PathVariable("id") Long id, Model model) {
		model.addAttribute("game", this.videogameService.findById(id));
		return "game.html";
	}
	@GetMapping("/games")
	public String showGames(Model model) {
		model.addAttribute("games", this.videogameService.findAll());
		return "games.html";
	}
}
