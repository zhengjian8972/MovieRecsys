package com.cmri.bcpdm.recsys.persistence;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmri.bcpdm.recsys.model.impl.Movie;
import com.cmri.bcpdm.recsys.util.WatchedEntity;

/**
 * A data access object (DAO) providing persistence and search support for
 * Movie entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cmri.bcpdm.recsys.model.impl.Movie
 * @author MyEclipse Persistence Tools
 */

public class MovieDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MovieDAO.class);
	// property constants
	public static final String MOVIE_TITLE = "movieTitle";
	public static final String YEAR = "year";
	public static final String GENRES = "genres";
	public static final String COUNTRIES = "countries";
	public static final String CAST_ID = "castId";
	public static final String CAST_NAME = "castName";
	public static final String DIRECTOR_ID = "directorId";
	public static final String DIRECTOR_NAME = "directorName";
	public static final String SUMMARY = "summary";
	public static final int SIMILARITY_MOVIES_NUM = 20;

	public void save(Movie transientInstance) {
		log.debug("saving Movie instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Movie persistentInstance) {
		log.debug("deleting Movie instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Movie findById(java.lang.String id) {
		log.debug("getting Movie instance with id: " + id);
		try {
			Movie instance = (Movie) getSession().get(
					"com.cmri.bcpdm.recsys.model.impl.Movie", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Movie instance) {
		log.debug("finding Movie instance by example");
		try {
			List results = getSession()
					.createCriteria("com.cmri.bcpdm.recsys.model.impl.Movie")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Movie instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Movie as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMovieTitle(Object movieTitle) {
		return findByProperty(MOVIE_TITLE, movieTitle);
	}

	public List findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List findByGenres(Object genres) {
		return findByProperty(GENRES, genres);
	}

	public List findByCountries(Object countries) {
		return findByProperty(COUNTRIES, countries);
	}

	public List findByCastId(Object castId) {
		return findByProperty(CAST_ID, castId);
	}

	public List findByCastName(Object castName) {
		return findByProperty(CAST_NAME, castName);
	}

	public List findByDirectorId(Object directorId) {
		return findByProperty(DIRECTOR_ID, directorId);
	}

	public List findByDirectorName(Object directorName) {
		return findByProperty(DIRECTOR_NAME, directorName);
	}

	public List findBySummary(Object summary) {
		return findByProperty(SUMMARY, summary);
	}

	public List findAll() {
		log.debug("finding all Movie instances");
		try {
			String queryString = "from Movie";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findPopMovie() {
		String queryString = "select mr.movie_Id,m.movie_Title,mr.avg_Rate,m.year,m.countries,m.director_name,m.cast_name,mr.rate_cnt from Movie_Rate mr,Movie m where m.movie_id=mr.movie_id and mr.avg_Rate >= 3.5 order by m.year desc, mr.avg_rate desc limit 0,12";
		Query queryObject = getSession().createSQLQuery(queryString);
		List list = queryObject.list();
		return list;
	}

	public List findTopMovie() {
		String queryString = "select mr.movie_Id,m.movie_Title,mr.avg_Rate,m.year,m.countries,m.director_name,m.cast_name,mr.rate_cnt from Movie_Rate mr,Movie m where m.movie_id=mr.movie_id  order by mr.avg_rate desc limit 0,12";
		Query queryObject = getSession().createSQLQuery(queryString);
		return queryObject.list();
	}
	
	public List findTop20Movie() {
		String queryString = "select mr.movie_Id,m.movie_Title,mr.avg_Rate,m.year,m.countries,m.director_name,m.cast_name,mr.rate_cnt from Movie_Rate mr,Movie m where m.movie_id=mr.movie_id  order by mr.avg_rate desc limit 0,20";
		Query queryObject = getSession().createSQLQuery(queryString);
		return queryObject.list();
	}
	
	public List findWatchedMovie(String userId) {
		String queryString = "select mr.movie_Id,m.movie_Title,mr.avg_Rate,m.year,m.countries,m.director_name,m.cast_name,mr.rate_cnt,watchedmovie.rating from Movie_Rate mr,Movie m,(select rate.movie_id as movie_id,rate.rating as rating,rate.rating_date as rating_date from rating rate where rate.user_id ='"+userId+"' )as watchedmovie where m.movie_id=mr.movie_id and m.movie_id = watchedmovie.movie_id order by watchedmovie.rating_date desc,watchedmovie.rating_date desc";
		Query queryObject = getSession().createSQLQuery(queryString);
		return queryObject.list();
	}
	
	public List findMovieDetail(String movieId) {
		String queryString = "select mr.movie_Id,m.movie_Title,mr.avg_Rate,m.year,m.countries,m.director_name,m.cast_name,mr.rate_cnt,m.summary,m.genres from Movie_Rate mr,Movie m where m.movie_id='" + movieId+"' and mr.movie_id = '"+movieId+"'";
		Query queryObject = getSession().createSQLQuery(queryString);
		return queryObject.list();
	}
	
	public Movie merge(Movie detachedInstance) {
		log.debug("merging Movie instance");
		try {
			Movie result = (Movie) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Movie instance) {
		log.debug("attaching dirty Movie instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Movie instance) {
		log.debug("attaching clean Movie instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List<Movie> searchMovies(String searchText) {
		// TODO Auto-generated method stub
		log.debug("merging Movie instance");
		try {
			String queryString = "select mr.movie_Id,m.movie_Title,mr.avg_Rate,m.year,m.countries,m.director_name,m.cast_name,mr.rate_cnt " +
					"from Movie_Rate mr,Movie m where m.movie_Title like '%"+searchText+"%' and m.movie_id=mr.movie_id";
			Query queryObject = getSession().createSQLQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public List<WatchedEntity> searchWatchedUsers(String movieId) {
		// TODO Auto-generated method stub
		String queryString = "SELECT  u.user_id, u.user_name, r.rating_date, r.rating FROM rating r , user u WHERE r.movie_id='" + movieId + "' AND u.user_id = r.user_id";
		Query queryObject = getSession().createSQLQuery(queryString);
		return queryObject.list();
	}

	public List findSimilatiryMovies(String movieId) {
		String queryString = "SELECT m.movie_id, m.movie_title FROM movie m, item_similarity i WHERE i.item_a='" + movieId + "' AND m.movie_id=i.item_b ORDER BY i.similarity DESC LIMIT "+ SIMILARITY_MOVIES_NUM +";";
		System.out.println(queryString);
		Query queryObject = getSession().createSQLQuery(queryString);
		return queryObject.list();
	}
	public List findSimilatiryMovies(String movieId, int recNum) {
		String queryString = "SELECT m.movie_id, m.movie_title,i.similarity FROM movie m, item_similarity i WHERE i.item_a='"
				+ movieId
				+ "' AND m.movie_id=i.item_b ORDER BY i.similarity DESC LIMIT "
				+ recNum + ";";
		Query queryObject = getSession().createSQLQuery(queryString);
		return queryObject.list();
	}
}