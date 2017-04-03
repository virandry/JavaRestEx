package io.virandry.model;


public class Movie {

	private int id;
	private String title;
	private int year;
	private String imagePath;
	private TomatoMeter tomatoMeter;
	private AudienceScore audienceScore;

	public Movie(){
		
	}
	
	public Movie(int id, String title, int year, String imagePath, TomatoMeter tomatoMeter, AudienceScore audienceScore) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.imagePath = imagePath;
		this.tomatoMeter = tomatoMeter;
		this.audienceScore = audienceScore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
