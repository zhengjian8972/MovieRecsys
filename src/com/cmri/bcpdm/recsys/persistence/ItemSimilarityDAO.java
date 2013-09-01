package com.cmri.bcpdm.recsys.persistence;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmri.bcpdm.recsys.model.impl.ItemSimilarity;
import com.cmri.bcpdm.recsys.model.impl.ItemSimilarityId;

/**
 * A data access object (DAO) providing persistence and search support for
 * ItemSimilarity entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cmri.bcpdm.recsys.model.impl.ItemSimilarity
 * @author MyEclipse Persistence Tools
 */

public class ItemSimilarityDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ItemSimilarityDAO.class);
	// property constants
	public static final String SIMILARITY = "similarity";

	public void save(ItemSimilarity transientInstance) {
		log.debug("saving ItemSimilarity instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ItemSimilarity persistentInstance) {
		log.debug("deleting ItemSimilarity instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ItemSimilarity findById(
			com.cmri.bcpdm.recsys.model.impl.ItemSimilarityId id) {
		log.debug("getting ItemSimilarity instance with id: " + id);
		try {
			ItemSimilarity instance = (ItemSimilarity) getSession().get(
					"com.cmri.bcpdm.recsys.model.impl.ItemSimilarity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ItemSimilarity instance) {
		log.debug("finding ItemSimilarity instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.cmri.bcpdm.recsys.model.impl.ItemSimilarity")
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
		log.debug("finding ItemSimilarity instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ItemSimilarity as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySimilarity(Object similarity) {
		return findByProperty(SIMILARITY, similarity);
	}

	public List findAll() {
		log.debug("finding all ItemSimilarity instances");
		try {
			String queryString = "from ItemSimilarity";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ItemSimilarity merge(ItemSimilarity detachedInstance) {
		log.debug("merging ItemSimilarity instance");
		try {
			ItemSimilarity result = (ItemSimilarity) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ItemSimilarity instance) {
		log.debug("attaching dirty ItemSimilarity instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ItemSimilarity instance) {
		log.debug("attaching clean ItemSimilarity instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}