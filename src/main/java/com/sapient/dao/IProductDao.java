package com.sapient.dao;

import java.util.List;

import com.sapient.exception.ApplicationException;
import com.sapient.vo.Product;

/**
 * Interface defines the APIs.
 * @author pratikgupta
 *
 */
public interface IProductDao {

	/**
	 * To save the product in database.
	 * @param product
	 */
	Object save(Product product) throws ApplicationException;

	/**
	 * To get product based on the type filter type and filter Value specified.
	 * @param product
	 */
	List<Product> filterProducts(String filterCriteria, String filterValue) throws ApplicationException;

	/**
	 * To delete the product by Id.
	 * @param id
	 * @return
	 */
	Object deleteById(String id);
}
