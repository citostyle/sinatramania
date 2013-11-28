package com.sinatramania.apitest;

import java.util.List;

public interface TodoDao {
   
   List<Todo> list();
   void store(Todo newTodo);
   
}
