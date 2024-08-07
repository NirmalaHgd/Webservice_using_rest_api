package org.learning.showroom.hibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="products")
@Table(name="products")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId")
	int productId;
	
	//@ManyToOne(targetEntity=BrandEntity.class)
	//@JoinColumn(name="brandId")
	//BrandEntity brandEntity;
	@Column(name="brandId")
	int brandId;
	
	@Column(name="productName")
	String productName;
	
	@Column(name="category")
	String category;
	
	@Column(name="cost")
	String cost;

	public ProductEntity() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	

	/*public BrandEntity getBrandEntity() {
		return brandEntity;
	}

	public void setBrandEntity(BrandEntity brandEntity) {
		this.brandEntity = brandEntity;
	}
*/
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	
	
	
}
