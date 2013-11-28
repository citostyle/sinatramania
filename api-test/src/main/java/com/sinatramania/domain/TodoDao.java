package com.sinatramania.domain;

import java.util.List;

public interface TodoDao {
   
   List<Todo> list();
   void store(Todo newTodo);
   
}
