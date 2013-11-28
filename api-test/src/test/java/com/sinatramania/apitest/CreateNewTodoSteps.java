package com.sinatramania.apitest;

import static org.junit.Assert.assertEquals;

import com.google.inject.Inject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateNewTodoSteps {

   private int numberOfTodos;

   @Inject
   private TodoDao todoDao;

   @Given("^a todo list with n elements$")
   public void rememberNumberOfTodos() {
      numberOfTodos = retrieveTodoCount();
   }

   private int retrieveTodoCount() {
      return todoDao.list().size();
   }

   @When("^I create a new todo$")
   public void createTodoToBuyMilk() {
      Todo todo = new Todo("buy milk");
      todoDao.store(todo);
   }

   @Then("^there should be exactly n plus one todos in the todo list$")
   public void checkNumberOfTodosHasIncreasedByOne() {
      assertEquals(numberOfTodos + 1, retrieveTodoCount());
   }

}
