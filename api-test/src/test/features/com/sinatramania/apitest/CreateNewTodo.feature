#encoding: utf-8
 
Feature: Create a new todo
 
  Scenario: Add a new todo
    Given a todo list with n elements
    When I create a new todo
    Then there should be exactly n plus one todos in the todo list 
