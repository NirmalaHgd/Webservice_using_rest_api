package org.learning.showroom.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learning.showroom.hibernate.entities.BrandEntity;
import org.learning.showroom.hibernate.entities.ProductEntity;

public class ProductsDAO {

	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(ProductEntity.class)
			.addAnnotatedClass(BrandEntity.class)
			.buildSessionFactory();

	public List<ProductEntity> getProductsByBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String hql = "from products a where a.brandId = " + brandId ;
		//System.out.println(sql);
		List<ProductEntity> productlist = session.createQuery(hql, ProductEntity.class).getResultList();
		return productlist;
		
	}

	public List<ProductEntity> getProductsByBrandAndCategory(int brandId, String category) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String hql = "from products a where a.brandId = " + brandId + " and category='"+category +"'" ;
		//System.out.println(sql);
		List<ProductEntity> productlist = session.createQuery(hql, ProductEntity.class).getResultList();
		return productlist;
	}
}
