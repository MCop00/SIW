package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Developer;
import it.uniroma3.siw.service.DeveloperService;

@Controller
public class DeveloperController {
	@Autowired DeveloperService developerService;
	
	@GetMapping("/formNewDeveloper")
	public String formNewDeveloper(Model model) {
		model.addAttribute("developer", new Developer());
		return "formNewDeveloper.html";
	}
	@PostMapping("/developers")
	public String newDeveloper(@ModelAttribute("developer") Developer developer, Model model) {
		if(!developerService.existsByNameCompany(developer.getNameCompany())) {
			this.developerService.save(developer);
			model.addAttribute("developer", developer);
			return "developer.html";
		} else {
			model.addAttribute("messaggioErrore", "Questo sviluppatore esiste già");
			return "formNewDeveloper.html";
		}
	}
	@GetMapping("/developer/{id}")
	public String getGame(@PathVariable("id") Long id, Model model) {
		model.addAttribute("developer", this.developerService.findById(id));
		return "developer.html";
	}
	@GetMapping("/developers")
	public String showDevelopers(Model model) {
		model.addAttribute("developers", this.developerService.findAll());
		return "developers.html";
	}
}
