package com.verizon.idb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.verizon.idb.TestUtil.TestUtil;
import com.verizon.idb.model.ISPPackage;
import com.verizon.idb.model.User;
import com.verizon.idb.service.PackageService;
import com.verizon.idb.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerIntegrationTest {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private UserService uServ;

	@Before
	public void setUp() throws Exception {
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllUsers() throws Exception {
		assertThat(this.uServ).isNotNull();
		List<User> c=this.uServ.getAllUsers();
		this.mockMvc.perform(get("/package"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void testAddUser() throws Exception {
		assertThat(this.uServ).isNotNull();

		User user = new User();
		user.setCustomerName("Girija");
		user.setMobileNumber("9600564498");
		user.setAddress("Chennai");

		mockMvc.perform(post("/users").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(user))).andDo(print()).andExpect(status().isOk());

	}

}
