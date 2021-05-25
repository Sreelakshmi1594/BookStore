package com.revature;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.model.Products;
import com.revature.repository.ProductRepository;
import com.revature.service.ProductServices;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ShopAppTest extends ShopAppApplicationTests{
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Mock
	private ProductServices productServices =mock(ProductServices.class);
	Products product;
	Products product1;
	private ProductRepository productRepo= mock(ProductRepository.class);
	
	
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		product = new Products(1,"book1","15","sree","123");
		product1 = new Products(2,"book1","15","sree","123");
		productServices=new  ProductServices();
		
	}
	
	@Test
	public void testproduct() throws Exception{
		product = new Products(1,"book1","15","sree","123");
		product1 = new Products(2,"book1","15","sree","123");
		productServices=new  ProductServices();
		when(productRepo.findAll()).thenReturn(Arrays.asList(product,product1));
		
		mockMvc.perform(get("/product/getAll")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		 .andExpect((ResultMatcher) jsonPath(("$[0].product_id"),(1)))
         .andExpect((ResultMatcher) jsonPath(("$[0].name"),("book1")))
         .andExpect((ResultMatcher) jsonPath("$[0].price", ("15")))
         .andExpect((ResultMatcher) jsonPath("$[0].author", ("sree")))
         .andExpect((ResultMatcher) jsonPath("$[0].categoryId", ("123")))
         .andExpect((ResultMatcher) jsonPath(("$[1].product_id"),(2)))
         .andExpect((ResultMatcher) jsonPath(("$[1].name"),("book1")))
         .andExpect((ResultMatcher) jsonPath("$[1].price", ("15")))
         .andExpect((ResultMatcher) jsonPath("$[1].author", ("sree")))
         .andExpect((ResultMatcher) jsonPath("$[1].categoryId", ("123")));
		
		verify(productRepo,times(1)).findAll();
		verifyNoMoreInteractions(productRepo);
	}
	
	@Test
	public void testProductCategory()throws Exception{
		product = new Products(1,"book1","15","sree","123");
		product1 = new Products(2,"book1","15","sree","123");
		productServices=new  ProductServices();
		when(productRepo.findByCategoryId("123")).thenReturn(Arrays.asList(product,product1));
		mockMvc.perform(get("/product/getAllCategory")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		 .andExpect((ResultMatcher) jsonPath(("$[0].product_id"),(1)))
         .andExpect((ResultMatcher) jsonPath(("$[0].name"),("book1")))
         .andExpect((ResultMatcher) jsonPath("$[0].price", ("15")))
         .andExpect((ResultMatcher) jsonPath("$[0].author", ("sree")))
         .andExpect((ResultMatcher) jsonPath("$[0].categoryId", ("123")))
         .andExpect((ResultMatcher) jsonPath(("$[1].product_id"),(2)))
         .andExpect((ResultMatcher) jsonPath(("$[1].name"),("book1")))
         .andExpect((ResultMatcher) jsonPath("$[1].price", ("15")))
         .andExpect((ResultMatcher) jsonPath("$[1].author", ("sree")))
         .andExpect((ResultMatcher) jsonPath("$[1].categoryId", ("123")));
		
		verify(productRepo,times(1)).findByCategoryId("123");
		verifyNoMoreInteractions(productRepo);
		
	}
	
	@Test
	public void modelTest1()throws Exception {
		assertEquals("book1",product.getName());
	}
}
