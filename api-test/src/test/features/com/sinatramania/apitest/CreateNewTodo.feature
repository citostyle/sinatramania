#encoding: utf-8
 
Feature: Create a new todo
 
  Scenario: Add a new todo
    Given an empty todo list
    When I create a new todo
    Then there should be exactly one todo in the todo list 
