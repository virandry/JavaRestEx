package io.virandry.model;

public class TomatoMeter {
	private String averageRating;
	private String reviewsCounted;
	private String fresh;
	private String rotten;

	public TomatoMeter(){
		
	}
	
	public TomatoMeter(String averageRating, String reviewsCounted, String fresh, String rotten) {
		this.averageRating = averageRating;
		this.reviewsCounted = reviewsCounted;
		this.fresh = fresh;
		this.rotten = rotten;
	}

	public String getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}

	public String getReviewsCounted() {
		return reviewsCounted;
	}

	public void setReviewsCounted(String reviewsCounted) {
		this.reviewsCounted = reviewsCounted;
	}

	public String getFresh() {
		return fresh;
	}

	public void setFresh(String fresh) {
		this.fresh = fresh;
	}

	public String getRotten() {
		return rotten;
	}

	public void setRotten(String rotten) {
		this.rotten = rotten;
	}
}
