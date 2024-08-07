package org.learning.showroom.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.learning.showroom.hibernate.entities.BrandEntity;
import org.learning.showroom.hibernate.entities.Link;
import org.learning.showroom.services.BrandsService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriInfo;

@Path("/showroom/brands")
public class Brands {
	
	BrandsService service = new BrandsService();
	
	
	@GET
	//child URI
	//@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = service.getBrands();
		return list;
	}
	
	@GET
	@Path("/{brandId}")
	@Produces(MediaType.APPLICATION_JSON)
	public BrandEntity getBrand(@PathParam("brandId") int brandId, @Context UriInfo uri) {
		Link self = new Link(uri.getAbsolutePath().toString(),"self");
		Link products = new Link (uri.getAbsolutePathBuilder().path("products").toString(),"products");
		BrandEntity brand = service.getBrand(brandId);
		List<Link> links = new ArrayList();
		links.add(self);
		links.add(products);
		brand.setLinks(links);
		return brand;
		
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postBrands(BrandEntity brand, @Context UriInfo uri) {
		//URI location =  uri.getAbsolutePath();
		
		service.addBrand(brand);
		/*String ResourceURL = uri.getAbsolutePath().toString() + "/"+ brand.getBrandId();
		URI location = URI.create(ResourceURL);*/
		
		URI location = uri.getAbsolutePathBuilder().path(Integer.toString(brand.getBrandId())).build();
		return Response.created(location).entity(brand).build();
				//.status(Status.CREATED).entity(brand).build();
	}
	
	
	@PUT
	//child URI
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putBrands(@PathParam("brandId") int brandId, BrandEntity updatedBrand) {
		updatedBrand.setBrandId(brandId);
		service.updateBrand(updatedBrand);
	}
	
	@DELETE
	//child URI
	@Path("/{brandId}")
	public void deleteBrands(@PathParam("brandId") int brandId) {
		service.deleteBrand(brandId);
	}
	
	@Path("/{brandId}/products")
	public Products productDelegation() {
		return new Products();
	}
	
}
