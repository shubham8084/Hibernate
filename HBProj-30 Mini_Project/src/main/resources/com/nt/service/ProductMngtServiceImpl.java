package com.nt.service;

import com.nt.dao.ProductDAO;
import com.nt.dao.ProductDAOImpl;
import com.nt.dto.ProductDTO;
import com.nt.entity.Product;

public class ProductMngtServiceImpl implements ProductMgntService {
	private ProductDAO dao;

	public ProductMngtServiceImpl() {
		this.dao = new ProductDAOImpl();
	}

	@Override
	public ProductDTO getProductDetails(int pid) {
		Product prod = null;
		ProductDTO dto = null;

		// get product using dao
		prod = dao.getProductDetails(pid);
		if (prod != null) {
			dto = new ProductDTO();
			// copy objet into dto
			System.out.println(prod.getPID()+" "+prod.getPName()+" "+prod.getPrice()+" "+prod.getQty());
			dto.setPid(prod.getPID());
			
			dto.setPName(prod.getPName());
			dto.setPrice((float) Math.round(prod.getPrice()));
			dto.setQty((float) Math.round(prod.getQty()));
			if (dto.getPrice() < 1000)
				dto.setCategories("Affordable");
			else
				dto.setCategories("premium");
			return dto;
		} // if
		else {
			return null;
		} // else

	}// method

}// class
