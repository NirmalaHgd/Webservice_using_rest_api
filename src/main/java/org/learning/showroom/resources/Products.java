package org.learning.showroom.resources;

import java.util.List;

import org.learning.showroom.hibernate.entities.ProductEntity;
import org.learning.showroom.services.ProductsService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


//@Path("/showroom/brands")
public class Products {
	ProductsService productsService = new ProductsService();
	
	@GET
	//@Path("/{brandId}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductEntity> getProductsByBrands(@PathParam("brandId") int brandId,
			@QueryParam("category") String category, @QueryParam("start") int start, @QueryParam("end") int end) {
		
		List<ProductEntity> Productlist;
		if(category != null) {
			Productlist = productsService.getProductsByBrandAndCategory(brandId, category);
		}
		else {
			Productlist = productsService.getProductsByBrand(brandId);
		}
		if(end > 0) {
			Productlist = Productlist.subList(start, end);
		}
		return Productlist;
	}
}
