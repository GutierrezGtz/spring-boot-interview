package com.compasso.springbootinterview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.compasso.springbootinterview.model.Client;
import com.compasso.springbootinterview.protocol.Gender;



public class ControllerTest extends AbstractTest{

	
	@Test
	   public void getList() throws Exception {
	      String uri = "/clients";
	      super.setUp();
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Client[] clientList = super.mapFromJson(content, Client[].class);
	      assertTrue(clientList.length > 0);
	   }
	
	@Test
	   public void postConverted() throws Exception {
	      String uri = "/clients/1";
	      Client cli = new Client();
	      cli.setAge(26);
	      cli.setClientName("eric");
	      cli.setGenderCode(Gender.M);
	      String inputJson = super.mapToJson(cli);
	      super.setUp();
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "{\"id\":1,\"clientName\":\"eric\",\"dateOfBirth\":null,\"age\":26,\"genderCode\":\"M\",\"cityCode\":{\"id\":1,\"cityName\":\"Porto Alegre\",\"estateCode\":{\"id\":1,\"estateName\":\"RS\"}}}");
	   }
	
}
