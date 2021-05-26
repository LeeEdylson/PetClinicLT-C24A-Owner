package com.tecsup.petclinic.web;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.domain.Owner;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class OwnerControllerTest {

	private static final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetOwners() throws Exception{
		
		int primer_owner=1;
		
		this.mockMvc.perform(get("/owners"))
					.andExpect(status().isOk())
					.andExpect(content()
					.contentType(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(jsonPath("$[0].id", is(primer_owner)));
	}
	
	@Test
	public void testFindOwnerOK() throws Exception{
		
		String nombre="George";
		String apellido="Franklin";
		
		mockMvc.perform(get("/owners/1"))
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.id", is(1)))
					.andExpect(jsonPath("$.first_name", is(nombre)))
					.andExpect(jsonPath("$.last_name", is(apellido)));
		
	}
	
	@Test
	public void testFindOwnerKO() throws Exception{
		
		mockMvc.perform(get("/owners/123"))
					.andExpect(status().isNotFound());
	}
	
	@Test
	public void testCreateOwner() throws Exception{
		
		String nombre="Pablo";
		String apellido="Verde";
		String direccion="yes";
		String ciudad="Alabama";
		String telefono="123456789";
		Owner newowner = new Owner(nombre,apellido,direccion,ciudad,telefono);
		
		mockMvc.perform(post("/owners")
				.content(om.writeValueAsString(newowner))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.first_name", is(nombre)))
				.andExpect(jsonPath("$.last_name", is(apellido)))
				.andExpect(jsonPath("$.address", is(direccion)))
				.andExpect(jsonPath("$.city",is(ciudad)))
				.andExpect(jsonPath("$.telephone", is(telefono)));
	}
	
	@Test
	public void testDeleteOwner() throws Exception{
			
		String nombre="Pablo";
		String apellido="Verde";
		String direccion="yes";
		String ciudad="Alabama";
		String telefono="123456789";
		Owner newowner = new Owner(nombre,apellido,direccion,ciudad,telefono);
		
		ResultActions mvcActions=mockMvc.perform(post("/owners")
				.content(om.writeValueAsBytes(newowner))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isCreated());
		
				String response = mvcActions.andReturn().getResponse().getContentAsString();
				
				Integer id = JsonPath.parse(response).read("$.id");
				
				mockMvc.perform(delete("/pets/"+id))
						.andExpect(status().isOk());
	}
	
}
