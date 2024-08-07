package org.learning.showroom.services;

import java.util.List;

import org.learning.showroom.hibernate.DAO.ProductsDAO;
import org.learning.showroom.hibernate.entities.ProductEntity;

public class ProductsService {

	ProductsDAO DAO = new ProductsDAO();
	
	public List<ProductEntity> getProductsByBrand(int brandId) {
		List<ProductEntity> productlist = DAO.getProductsByBrand(brandId);
		return productlist;
	}

	public List<ProductEntity> getProductsByBrandAndCategory(int brandId, String category) {
		List<ProductEntity> productlist = DAO.getProductsByBrandAndCategory(brandId, category);
		return productlist;
	}

}
