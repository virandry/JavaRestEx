package io.virandry.model;

public class AudienceScore {

	private String averageRating;
	private String userRating;

	public AudienceScore(){
		
	}
	
	public AudienceScore(String averageRating, String userRating) {
		this.averageRating = averageRating;
		this.userRating = userRating;
	}

	public String getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}

	public String getUserRating() {
		return userRating;
	}

	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}
}
