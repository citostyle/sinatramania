package com.sinatramania.apitest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateNewTodoSteps {

   private int numberOfTodos;

   @Given("^a todo list with n elements$")
   public void rememberNumberOfTodos() {
      numberOfTodos = listTodos().size();
   }

   private List<Todo> listTodos() {
      return restApi().get(new GenericType<List<Todo>>() {});
   }

   private Builder restApi() {
      ClientConfig config = new DefaultClientConfig();
      config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
      Client client = Client.create(config);
      WebResource service = client.resource(UriBuilder.fromUri("http://127.0.0.1:3000").build());
      Builder web = service.path("todos").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
      return web;
   }

   @When("^I create a new todo$")
   public void createTodoToBuyMilk() {
      Todo todo = new Todo("buy milk");
      createTodo(todo);
   }

   private void createTodo(Todo todo) {
      restApi().put(todo);
   }

   @Then("^there should be exactly n plus one todos in the todo list$")
   public void checkNumberOfTodosHasIncreasedByOne() {
      assertEquals(numberOfTodos + 1, listTodos().size());
   }

}
