package com.sapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.dao.IProductDao;
import com.sapient.exception.ApplicationException;
import com.sapient.util.Constants;
import com.sapient.vo.Product;
import com.sapient.vo.Response;

/**
 * Base controller of the Product Catalog microservice.
 * @author pratikgupta
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	IProductDao productDao;
	
	/**
	 * method to save the product. request and response content type is in application/json format.
	 * @param product
	 * @return
	 */
	@RequestMapping(value="/addproduct", method=RequestMethod.POST)
	public Response addProduct(@RequestBody Product product) {
		
		Response response = new Response();
		try{
			
			response.setObject(productDao.save(product));
			response.setStatus(Constants.SUCCESS);
		} catch (ApplicationException ex) {
			response.setStatus(Constants.ERROR);
			response.setErrorCode(ex.getErrorCode());
			response.setErrorMsg(ex.getMessage());
		}
		return response;
	}

	/**
	 * method to save the product based on the type provided
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/getproducts/{type}", method=RequestMethod.GET)
	public Response getProductsByType(@PathVariable("type") String type) {
		
		Response response = new Response();
		try{
			response.setObject(productDao.findByType(type));
			response.setStatus(Constants.SUCCESS);
		} catch (ApplicationException ex) {
			response.setStatus(Constants.ERROR);
			response.setErrorCode(ex.getErrorCode());
			response.setErrorMsg(ex.getMessage());
		}
		return response;
	}

	/**
	 * method to save the product based on the type provided
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/deleteproduct/{id}", method=RequestMethod.GET)
	public Response deleteProductByID(@PathVariable("id") String id) {
		
		Response response = new Response();
		try{
			response.setObject(productDao.deleteById(id));
			response.setStatus(Constants.SUCCESS);
		} catch (ApplicationException ex) {
			response.setStatus(Constants.ERROR);
			response.setErrorCode(ex.getErrorCode());
			response.setErrorMsg(ex.getMessage());
		}
		return response;
	}

}
