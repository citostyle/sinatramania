package com.sinatramania.apitest;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateNewTodoSteps {
   
   private int n;

   @Given("^a todo list with n elements$")
   public void a_todo_list_with_n_elements() {
      List<Todo> currentTodos = getTodos();
      this.n = currentTodos.size();
   }

   private List<Todo> getTodos() {
      ClientConfig config = new DefaultClientConfig();
      config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
      Client client = Client.create(config);
      WebResource service = client.resource(UriBuilder.fromUri("http://127.0.0.1:3000").build());
      return service.path("todos").accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Todo>>() {});      
   }

   @When("^I create a new todo$")
   public void I_create_a_new_todo() {
      throw new PendingException();
   }

   @Then("^there should be exactly n plus one todos in the todo list$")
   public void there_should_be_exactly_n_plus_one_todos_in_the_todo_list() {
      throw new PendingException();
   }

}
