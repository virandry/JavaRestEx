package io.virandry.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Type;

@NamedQueries({
	@NamedQuery(
	name = "findAllMovies",
	query = "FROM Movie"
	)
})
@Entity
public class Movie {

	@Id
	@Column(name = "_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Type(type = "objectid")
	private String id;
	private String title;
	private int year;
	private String imagePath;

	@Embedded
	private TomatoMeter tomatoMeter;

	@Embedded
	private AudienceScore audienceScore;

	public Movie() {

	}

	public Movie(String title, int year, String imagePath, TomatoMeter tomatoMeter, AudienceScore audienceScore) {
		this.title = title;
		this.year = year;
		this.imagePath = imagePath;
		this.tomatoMeter = tomatoMeter;
		this.audienceScore = audienceScore;
	}

	public Movie(String id, String title, int year, String imagePath, TomatoMeter tomatoMeter,
			AudienceScore audienceScore) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.imagePath = imagePath;
		this.tomatoMeter = tomatoMeter;
		this.audienceScore = audienceScore;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public TomatoMeter getTomatoMeter() {
		return tomatoMeter;
	}

	public void setTomatoMeter(TomatoMeter tomatoMeter) {
		this.tomatoMeter = tomatoMeter;
	}

	public AudienceScore getAudienceScore() {
		return audienceScore;
	}

	public void setAudienceScore(AudienceScore audienceScore) {
		this.audienceScore = audienceScore;
	}

}
