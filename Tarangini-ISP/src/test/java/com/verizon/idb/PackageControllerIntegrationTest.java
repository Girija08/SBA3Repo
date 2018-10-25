package com.verizon.idb;
import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.idb.model.ISPPackage;
import com.verizon.idb.service.PackageService;




@RunWith(SpringRunner.class)
@SpringBootTest

public class PackageControllerIntegrationTest {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private PackageService pServ;

	@Before
	public void setUp() throws Exception {
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllPackages() throws Exception {
		assertThat(this.pServ).isNotNull();
		
		List<ISPPackage> c=this.pServ.getAllPackages();	
		
		c.add(new ISPPackage());
		this.mockMvc.perform(get("/package"))
		.andExpect(status().isOk())
		.andDo(print());
	}
}
	