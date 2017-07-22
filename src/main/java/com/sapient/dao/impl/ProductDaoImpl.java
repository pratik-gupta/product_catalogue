package com.sapient.dao.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.sapient.dao.IProductDao;
import com.sapient.exception.ApplicationException;
import com.sapient.vo.Product;

/**
 * Implementation of the Interface defines the API.
 * @author pratikgupta
 *
 */
@Repository
public class ProductDaoImpl implements IProductDao {

	@Autowired
	MongoOperations mongo;
	
	/**
	 * To save the product in database.
	 * @param product
	 */
	public Object save(Product product) throws ApplicationException {
		try {
			mongo.insert(product);
		} catch (DuplicateKeyException ex) {
			//TODO logging of error
			throw new ApplicationException("DUPLICATE_PRODUCT");
		} catch (Exception ex) {
			//TODO logging of error
			throw new ApplicationException("SOME_EXCEPTION_DURING_INSERT");
		}
		return product.getId();
	}

	/**
	 * To get product based on the filter type and filter value specified.
	 * @param product
	 */
	
	public List<Product> filterProducts(String filterCriteria, String filterValue) throws ApplicationException {
		if("category".equalsIgnoreCase(filterCriteria))
			return (List<Product>) mongo.find(query(where("category").is(filterValue)), Product.class);

		if("name".equalsIgnoreCase(filterCriteria)) {
			return (List<Product>) mongo.find(query(where("name").is(filterValue)), Product.class);
		}
		return null;
		
	};

	/**
	 * To delete the product based on the Id.
	 */
	public Object deleteById(String id) throws ApplicationException {
		return mongo.remove(query(where("id").is(id)), Product.class);
		
	}
}
