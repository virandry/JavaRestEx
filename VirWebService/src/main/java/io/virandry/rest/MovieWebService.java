package io.virandry.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.annotation.JacksonFeatures;

import io.virandry.model.AudienceScore;
import io.virandry.model.Movie;
import io.virandry.model.TomatoMeter;

@Path("/json/movie")
public class MovieWebService {

	static Movie movie1 = new Movie(1, "KONG: SKULL ISLAND", 2017, "/jerjack/images/kong.jpg",
				new TomatoMeter("6.6/10", "273", "212", "61"), new AudienceScore("3.7/5", "38,245"));
	static Movie movie2 = new Movie(2, "Ghost in the Shell", 2017, "/jerjack/images/ghost.jpg",
				new TomatoMeter("5.5/10", "159", "68", "91"), new AudienceScore("3.5/5", "28,203"));
	
	
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

	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable =  { SerializationFeature.INDENT_OUTPUT })
	public ArrayList<Movie> getMovieListinJSON() {

		ArrayList<Movie> movieList = new ArrayList<Movie>();
		
		movieList.add(movie1);
		movieList.add(movie2);
		return movieList;
	}

}
