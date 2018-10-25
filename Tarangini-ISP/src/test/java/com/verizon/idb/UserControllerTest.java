package com.verizon.idb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.idb.TestUtil.TestUtil;
import com.verizon.idb.model.User;
import com.verizon.idb.restApi.UserController;
import com.verizon.idb.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)

public class UserControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private UserService userServiceMock;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockMvc = null;
	}

	@Test
	public void testGetAllUsers() throws Exception {
		assertThat(this.userServiceMock).isNotNull();

		List<User> userList = new ArrayList<>();
		userList.add(new User());

		when(userServiceMock.getAllUsers()).thenReturn(userList);

		mockMvc.perform(get("/users")).andExpect(status().isOk()).andDo(print());

	}
	@Test
	public void testAddUser() throws Exception {
		assertThat(this.userServiceMock).isNotNull();

		User user = new User();

		user.setCustomerName("Girija");
		user.setMobileNumber("1515151515");
		user.setAddress("Chennai");
		user.setTimeSlot("4pm to 7pm");

		User userAdded = new User();
		userAdded.setCustomerName("Girija");
		userAdded.setMobileNumber("1515151515");
		userAdded.setAddress("Chennai");
		userAdded.setTimeSlot("4pm to 7pm");

		when(userServiceMock.addUser(Mockito.any(User.class))).thenReturn(userAdded);

		mockMvc.perform(post("/users").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(user))).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));

	}
}
