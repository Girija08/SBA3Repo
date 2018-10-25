package com.verizon.idb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.idb.model.ISPPackage;
import com.verizon.idb.restApi.PackageController;
import com.verizon.idb.service.PackageService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PackageController.class)

public class PackageControllerTest {
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private PackageService packServiceMock;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockMvc = null;
	}

	@Test
	public void testGetAllPackages() throws Exception {
		assertThat(this.packServiceMock).isNotNull();

		List<ISPPackage> packList = new ArrayList<>();
		packList.add(new ISPPackage());

		when(packServiceMock.getAllPackages()).thenReturn(packList);

		mockMvc.perform(get("/package")).andExpect(status().isOk()).andDo(print());

	}
	
}
