package com.sinatramania.domain;

public class Todo {

   private String description;

   public Todo() { }
   
   public Todo(String description) {
      this.description = description;
   }
   
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

}
