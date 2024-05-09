package it.uniroma3.siw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Award;
import it.uniroma3.siw.model.Videogame;
import it.uniroma3.siw.service.AwardService;
import it.uniroma3.siw.service.VideogameService;

@Controller
public class AwardController {
	@Autowired AwardService awardService;
	@Autowired VideogameService videogameService;
	
	@GetMapping("/indexAward")
	public String indexAward() {
		return "indexAward.html";
	}
	@GetMapping("/formNewAward")
	public String formNewAward(Model model) {
		model.addAttribute("award", new Award());
		return "formNewAward.html";
	}
	@PostMapping("/awards")
	public String newAward(@ModelAttribute("award") Award award, Model model) {
		if(!awardService.existsByTypeAndYear(award.getType(), award.getYear())) {
			this.awardService.save(award);
			model.addAttribute("award", award);
			return "award.html";
		} else {
			model.addAttribute("messaggioErrore", "Questo premio esiste già");
			return "formNewAward.html";
		}
	}
	@GetMapping("/award/{id}")
	public String getAward(@PathVariable("id") Long id, Model model) {
		model.addAttribute("award", this.awardService.findById(id));
		return "award.html";
	}
	@GetMapping("/awards")
	public String showAwards(Model model) {
		model.addAttribute("awards", this.awardService.findAll());
		return "awards.html";
	}
	@GetMapping("/manageAwards")
	public String manageAwards(Model model) {
		model.addAttribute("awards", this.awardService.findAll());
		return "manageAwards.html";
	}
	@GetMapping("/formUpdateAward/{id}/{awardType}")
	public String formUpdateAward(@PathVariable("id") Long id, Model model) {
		model.addAttribute("award", awardService.findById(id));
		return "formUpdateAward.html";
	}
	@GetMapping("/updateNominations/{id}/{awardType}")
	public String updateNominations(@PathVariable("awardType") String awardType, @PathVariable("id") Long id, Model model) {
		List<Videogame> nominationsToAdd = this.nominationsToAdd(awardType, id);
		model.addAttribute("nominationsToAdd", nominationsToAdd);
		model.addAttribute("award", this.awardService.findById(id));

		return "nominationsToAdd.html";
	}
	@GetMapping(value="/addNominationToAward/{nominationId}/{awardId}/{awardType}")
	public String addNominationToAward(@PathVariable("nominationId") Long nominationId, @PathVariable("awardType") String awardType, @PathVariable("awardId") Long awardId, Model model) {
		Award award = this.awardService.findById(awardId);
		Videogame nomination = this.videogameService.findById(nominationId);
		List<Videogame> nominations = award.getNominations();
		nominations.add(nomination);
		this.awardService.save(award);
		
		List<Videogame> nominationsToAdd = nominationsToAdd(awardType, awardId);
		
		model.addAttribute("award", award);
		model.addAttribute("nominationsToAdd", nominationsToAdd);

		return "nominationsToAdd.html";
	}
	@GetMapping(value="/removeNominationFromAward/{nominationId}/{awardId}/{awardType}")
	public String removeNominationFromAward(@PathVariable("nominationId") Long nominationId, @PathVariable("awardType") String awardType,@PathVariable("awardId") Long awardId, Model model) {
		Award award = this.awardService.findById(awardId);
		Videogame nomination= this.videogameService.findById(nominationId);
		List<Videogame> nominations= award.getNominations();
		nominations.remove(nomination);
		this.awardService.save(award);

		List<Videogame> nominationsToAdd = nominationsToAdd(awardType,awardId);
		
		model.addAttribute("award", award);
		model.addAttribute("nominationsToAdd", nominationsToAdd);

		return "nominationsToAdd.html";
	}
	private List<Videogame> nominationsToAdd(String awardType, Long awardId) {
		List<Videogame> nominationsToAdd = new ArrayList<>();

		for (Videogame v : videogameService.findVideogamesByAwardTypeAndNotInAward(awardType, awardId)) {
			nominationsToAdd.add(v);
		}
		return nominationsToAdd;
	}
}
