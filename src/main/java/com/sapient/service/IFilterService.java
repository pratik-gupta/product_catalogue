package com.sapient.service;

/**
 * Interface to filter the Product Document based on the filter criteria and filter value.
 * @author pratikgupta
 *
 */
public interface IFilterService {

	public Object getFilteredProducts(String filterCriteria, String filteValue);
}
