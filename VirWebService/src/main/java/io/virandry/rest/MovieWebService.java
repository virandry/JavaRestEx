package io.virandry.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.annotation.JacksonFeatures;

import io.virandry.config.HibernateOGMUtilEMF;
import io.virandry.model.AudienceScore;
import io.virandry.model.Movie;
import io.virandry.model.TomatoMeter;

@Path("/json/movie")
public class MovieWebService {

	EntityManagerFactory entityManagerFactory = HibernateOGMUtilEMF.getEntityManagerFactory();

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

		EntityManager em = entityManagerFactory.createEntityManager();

		try {
			em.getTransaction().begin();
			Query query = em.createNamedQuery("findAllMovies");
			@SuppressWarnings("unchecked")
			List<Movie> movies = query.getResultList();
			em.getTransaction().commit();
			return movies;
		} catch (RuntimeException e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

}
