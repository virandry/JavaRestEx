package io.virandry.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.annotation.JacksonFeatures;

import io.virandry.config.HibernateOGMUtil;
import io.virandry.model.AudienceScore;
import io.virandry.model.Movie;
import io.virandry.model.TomatoMeter;

@Path("/json/movie")
public class MovieWebService {

	private static Session session;

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
	@JacksonFeatures(serializationEnable = { SerializationFeature.INDENT_OUTPUT })
	public List<Movie> getMovieListinJSON() {

		session = HibernateOGMUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			Query query = session.getNamedQuery("findAllMovies");
			@SuppressWarnings("unchecked")
			List<Movie> movies = query.list();
			session.flush();
			session.getTransaction().commit();
			return movies;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

	}

}
