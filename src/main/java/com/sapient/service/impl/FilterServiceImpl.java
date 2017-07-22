package com.sapient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.IProductDao;
import com.sapient.service.IFilterService;

/**
 * Implementation of the IService interface.
 * @author pratikgupta
 *
 */
@Service
public class FilterServiceImpl implements IFilterService {

	@Autowired
	IProductDao productDao;
	
	@Override
	public Object getFilteredProducts(String filterCriteria, String filterValue) {
	
		return productDao.filterProducts(filterCriteria, filterValue);
	}
}
