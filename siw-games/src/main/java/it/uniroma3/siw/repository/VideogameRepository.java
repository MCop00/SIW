package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Developer;
import it.uniroma3.siw.model.Videogame;

public interface VideogameRepository extends CrudRepository<Videogame,Long> {

	boolean existsByTitleAndYear(String title, Integer year);

	public List<Videogame> findByYear(Integer year);

	boolean existsByTitleAndDeveloper(String title, Developer developer);

}
