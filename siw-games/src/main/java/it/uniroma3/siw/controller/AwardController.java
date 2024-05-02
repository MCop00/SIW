package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Award;
import it.uniroma3.siw.service.AwardService;

@Controller
public class AwardController {
	@Autowired AwardService awardService;
	
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
}
