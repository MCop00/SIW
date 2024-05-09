package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Developer;
import it.uniroma3.siw.model.Videogame;

public interface VideogameRepository extends CrudRepository<Videogame,Long> {

	boolean existsByTitleAndYear(String title, Integer year);

	public List<Videogame> findByYear(Integer year);

	boolean existsByTitleAndDeveloper(String title, Developer developer);
	
	@Query(value = "select * "
			+ "from videogame v "
			+ "where v.genre =:awardType and v.id not in "
			+ "(select nominations_id "
			+ "from award_nominations "
			+ "where award_nominations.nominations_id = :awardId)", nativeQuery = true)
	public  Videogame[] findVideogamesByAwardTypeAndNotInAward(@Param("awardType") String awardType, @Param("awardId") Long awardId);
}
