package com.cmri.bcpdm.recsys.persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmri.bcpdm.recsys.model.impl.Movie;
import com.cmri.bcpdm.recsys.model.impl.Rating;
import com.cmri.bcpdm.recsys.model.impl.RatingId;
import com.cmri.bcpdm.recsys.model.impl.User;

/**
 * A data access object (DAO) providing persistence and search support for
 * Rating entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cmri.bcpdm.recsys.model.impl.Rating
 * @author MyEclipse Persistence Tools
 */

public class RatingDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(RatingDAO.class);
	// property constants
	public static final String RATING = "rating";

	public void save(Rating transientInstance) {
		Transaction trans = getSession().beginTransaction();
		log.debug("saving Rating instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		trans.commit();
	}

	public void delete(Rating persistentInstance) {
		log.debug("deleting Rating instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Rating findById(com.cmri.bcpdm.recsys.model.impl.RatingId id) {
		log.debug("getting Rating instance with id: " + id);
		try {
			Rating instance = (Rating) getSession().get(
					"com.cmri.bcpdm.recsys.model.impl.Rating", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Rating instance) {
		log.debug("finding Rating instance by example");
		try {
			List results = getSession()
					.createCriteria("com.cmri.bcpdm.recsys.model.impl.Rating")
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
		log.debug("finding Rating instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Rating as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRating(Object rating) {
		return findByProperty(RATING, rating);
	}

	public List findAll() {
		log.debug("finding all Rating instances");
		try {
			String queryString = "from Rating";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Rating merge(Rating detachedInstance) {
		log.debug("merging Rating instance");
		try {
			Rating result = (Rating) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Rating instance) {
		log.debug("attaching dirty Rating instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Rating instance) {
		log.debug("attaching clean Rating instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public List getUserRating(String userId, String movieId) {
		String queryString = "SELECT  r.rating FROM rating r WHERE r.movie_id='"
				+ movieId + "' AND r.user_id =" + userId;
		Query queryObject = getSession().createSQLQuery(queryString);
		return queryObject.list();
	}

	public String setUserRating(String userId, String movieId, int rate) {
		Rating rating = new Rating();

		UserDAO userDao = new UserDAO();
		MovieDAO movieDao = new MovieDAO();
		RatingDAO ratingDAO = new RatingDAO();
		User user = userDao.findById(userId);
		Movie movie = movieDao.findById(movieId);
		if (user != null && movie != null) {
			RatingId ratingId = new RatingId(user, movie);
			Rating temp = ratingDAO.findById(ratingId);
			if (temp != null) {
				ratingDAO.delete(temp);
			}
			rating.setRating(rate);
			Date now = new Date();
			rating.setRatingDate(now);
			rating.setId(ratingId);

			ratingDAO.save(rating);
			return "success";
		}
		return "error";
	}
}