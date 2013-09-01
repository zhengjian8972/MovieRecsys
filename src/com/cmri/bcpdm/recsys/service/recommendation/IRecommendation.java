
package com.cmri.bcpdm.recsys.service.recommendation;

import java.util.List;
/**
 * Product Interface of Abstract Factory Mode
 * @author lifanglin
 *
 * @param <T> type of recommended item 
 */
public interface IRecommendation<T> {

	List<T> recommend();
}
