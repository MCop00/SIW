package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Videogame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String genre;
	@Min(1972)
	@Max(2024)
	private Integer year;
	private String budget;
	private String urlImage;
	private List<String> platforms;
	private Float vote;
	
	@OneToMany(mappedBy = "winner")
	private List<Award> awardsWon;
	
	@ManyToOne
	@JoinColumn(name="developer_id")
	private Developer developer;
	@OneToMany(mappedBy="videogame")
	private List<Review> reviews;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public List<String> getPlatforms() {
		return platforms;
	}
	public void setPlatforms(List<String> platforms) {
		this.platforms = platforms;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public Float getVote() {
		return vote;
	}
	public void setVote(Float vote) {
		this.vote = vote;
	}
	public List<Award> getAwardsWon() {
		return awardsWon;
	}
	public void setAwardsWon(List<Award> awardsWon) {
		this.awardsWon = awardsWon;
	}
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	@Override
	public int hashCode() {
		return Objects.hash(title, year);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videogame other = (Videogame) obj;
		return Objects.equals(title, other.title) && Objects.equals(year, other.year);
	}
}
