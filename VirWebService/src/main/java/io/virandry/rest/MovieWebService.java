package io.virandry.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import io.virandry.model.AudienceScore;
import io.virandry.model.Movie;
import io.virandry.model.TomatoMeter;

@XmlRootElement
@Path("/json/movie")
public class MovieWebService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getMovieinJSON() {

		Movie movie = new Movie();
		movie.setTitle("KONG: SKULL ISLAND");
		movie.setYear(2017);
		movie.setImagePath("/images/kong.jpg");
		TomatoMeter tomatoMeter = new TomatoMeter();
		tomatoMeter.setAverageRating("6.6/10");
		tomatoMeter.setReviewsCounted("273");
		tomatoMeter.setFresh("212");
		tomatoMeter.setRotten("61");
		movie.setTomatoMeter(tomatoMeter);
		AudienceScore audienceScore = new AudienceScore();
		audienceScore.setAverageRating("3.7/5");
		audienceScore.setUserRating("38,245");
		movie.setAudienceScore(audienceScore);

		return movie;
	}
}
