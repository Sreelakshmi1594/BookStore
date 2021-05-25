package com.revature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.model.Products;
import com.revature.service.ProductServices;

public class ProductTest extends ShopAppApplicationTests{
	
	@Mock
	private ProductServices productServices =mock(ProductServices.class);
	Products product;
	Products product1;
	
	
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		product = new Products(1,"book1","15","sree","123");
		product1 = new Products(2,"book1","15","sree","123");
	}
	
	@Test
	public void modelTest1()throws Exception {
		assertEquals("book1",product.getName());
	}

}
