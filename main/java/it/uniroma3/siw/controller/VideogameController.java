package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Developer;
import it.uniroma3.siw.model.Videogame;
import it.uniroma3.siw.service.DeveloperService;
import it.uniroma3.siw.service.VideogameService;
import jakarta.transaction.Transactional;

@Controller
public class VideogameController {
	@Autowired VideogameService videogameService;
	@Autowired DeveloperService developerService;
	
	@GetMapping("/formNewGame")
	public String formNewGame(Model model) {
		model.addAttribute("game", new Videogame());
		model.addAttribute("developers", developerService.findAll());
		return "formNewGame.html";
	}
	@PostMapping("/games")
	public String newGame(@ModelAttribute("game") Videogame game,Model model) {
		if(!videogameService.existsByTitleAndYear(game.getTitle(), game.getYear())) {
			
			this.videogameService.save(game);
			model.addAttribute("game", game);
			return "default/game.html";
		} else {
			model.addAttribute("messaggioErrore", "Questo gioco esiste già");
			return "formNewGame.html";
		}
	}
	@GetMapping("/default/game/{id}")
	public String getGame(@PathVariable("id") Long id, Model model) {
		model.addAttribute("game", this.videogameService.findById(id));
		return "default/game.html";
	}
	@GetMapping("/default/games")
	public String showGames(Model model) {
		model.addAttribute("games", this.videogameService.findAll());
		return "default/games.html";
	}
	@GetMapping("/formSearchGames")
	public String formSearchGames() {
		return "formSearchGames.html";
	}
	@PostMapping("/searchGames")
	public String searchGames(Model model, @RequestParam Integer year) {
		model.addAttribute("games", this.videogameService.findByYear(year));
		return "foundGames.html";
	}
	@Transactional
	public void deleteAllByDeveloper(Developer developer) {
		videogameService.deleteAllByDeveloper(developer);
	}
}
