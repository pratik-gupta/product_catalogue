package com.sapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.dao.IProductDao;
import com.sapient.exception.ApplicationException;
import com.sapient.service.IFilterService;
import com.sapient.util.Constants;
import com.sapient.vo.Product;
import com.sapient.vo.Response;

/**
 * Base controller of the Product Catalogue microservice.
 * @author pratikgupta
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	IProductDao productDao;
	
	@Autowired
	IFilterService filterService;
	/**
	 * method to save the product. request and response content type is in application/json format.
	 * @param product
	 * @return
	 */
	@RequestMapping(value="/addproduct", method=RequestMethod.POST)
	public Response addProduct(@Validated @RequestBody Product product, BindingResult bindingResult) {
		
		Response response = new Response();
		
		if(bindingResult.hasErrors()) {
			response.setStatus(Constants.ERROR);
			response.setErrorCode(Constants.INVALID_FIELD);
			response.setErrorMsg(bindingResult.getFieldError().getDefaultMessage());
			return response;
		}
	
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
	@RequestMapping(value="/getproducts", method=RequestMethod.GET)
	public Response getProducts(@RequestParam("filter") String filterCriteria, @RequestParam("filterValue") String filterValue) {
		
		Response response = new Response();
		try{
			response.setObject(filterService.getFilteredProducts(filterCriteria, filterValue));
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
