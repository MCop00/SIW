package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Videogame;
import it.uniroma3.siw.repository.VideogameRepository;

@Service
public class VideogameService {
	@Autowired private VideogameRepository videogameRepository;

	public void save(Videogame game) {
		videogameRepository.save(game);
	}
	public Videogame findById(Long id) {
		return videogameRepository.findById(id).get();
	}
	public Iterable<Videogame> findAll() {
		return videogameRepository.findAll();
	}
	// metodi chiamati
	public boolean existsByTitleAndYear(String title, Integer year) {
		return videogameRepository.existsByTitleAndYear(title, year);
	}
	public List<Videogame> findByYear(Integer year) {
		return videogameRepository.findByYear(year);
	}
	public Videogame[] findVideogamesByAwardTypeAndNotInAward(String awardType, Long awardId) {
		return videogameRepository.findVideogamesByAwardTypeAndNotInAward(awardType, awardId);
	}
}
