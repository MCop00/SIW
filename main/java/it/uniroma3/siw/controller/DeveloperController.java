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
import jakarta.transaction.Transactional;

@Controller
public class DeveloperController {
	@Autowired DeveloperService developerService;
	@Autowired VideogameController videogameController;
	
	@GetMapping("/admin/formNewDeveloper")
	public String formNewDeveloper(Model model) {
		model.addAttribute("developer", new Developer());
		return "admin/formNewDeveloper.html";
	}
	@PostMapping("/admin/developers")
	public String newDeveloper(@ModelAttribute("developer") Developer developer, Model model) {
		if(!developerService.existsByNameCompany(developer.getNameCompany())) {
			this.developerService.save(developer);
			model.addAttribute("developer", developer);
			return "admin/developer.html";
		} else {
			model.addAttribute("messaggioErrore", "Questo sviluppatore esiste già");
			return "admin/formNewDeveloper.html";
		}
	}
	@GetMapping("/admin/developer/{id}")
	public String getGame(@PathVariable("id") Long id, Model model) {
		model.addAttribute("developer", this.developerService.findById(id));
		return "admin/developer.html";
	}
	@GetMapping("/admin/developers")
	public String showDevelopers(Model model) {
		model.addAttribute("developers", this.developerService.findAll());
		return "admin/developers.html";
	}
	@Transactional
	@GetMapping("/admin/deleteDeveloper/{developerId}")
	public String deleteDeveloper(@PathVariable("developerId") Long id, Model model) {
		Developer developer = this.developerService.findById(id);
		videogameController.deleteAllByDeveloper(developer);
		developerService.deleteById(id);
		return "admin/confirmDeleteDeveloper.html";
	}
}
