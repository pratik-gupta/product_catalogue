package com.sapient.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.*;

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
	 * To get product based on the type specefied
	 * @param product
	 */
	public List<Product> findByType(String type) throws ApplicationException {
		return mongo.find(query(where("type").is(type)), Product.class);
	}

	/**
	 * 
	 */
	public Object deleteById(String id) throws ApplicationException {
		return mongo.remove(query(where("id").is(id)), Product.class);
		
	}
}
