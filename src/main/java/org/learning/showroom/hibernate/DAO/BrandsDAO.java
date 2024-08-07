package org.learning.showroom.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learning.showroom.hibernate.entities.BrandEntity;
import org.learning.showroom.resources.Brands;

public class BrandsDAO {

	SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(BrandEntity.class)
				.buildSessionFactory();
	
	public List<BrandEntity> getBrands() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<BrandEntity> list = session.createQuery("from brands", BrandEntity.class).getResultList();
		return list;
	}

	public BrandEntity getBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		return session.get(BrandEntity.class, brandId);
		
	}
	
	public void addBrand(BrandEntity brand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.persist(brand);
		session.getTransaction().commit();
	}

	public void updateBrand(BrandEntity updatedBrand) {
		Session session =  factory.getCurrentSession();
		session.beginTransaction();
		int id = updatedBrand.getBrandId();
		BrandEntity brand = session.get(BrandEntity.class, id);
		brand.setBrandName(updatedBrand.getBrandName());
		session.getTransaction().commit();
		
	}

	public void deleteBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity brand = session.get(BrandEntity.class, brandId);
		session.remove(brand);
		session.getTransaction().commit();
		
	}

	

}
