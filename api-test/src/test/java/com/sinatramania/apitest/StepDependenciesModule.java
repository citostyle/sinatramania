package com.sinatramania.apitest;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.sinatramania.domain.TodoDao;
import com.sinatramania.domain.TodoDaoRestProxy;

public class StepDependenciesModule extends AbstractModule {

   @Override
   protected void configure() {
      bindConstant().annotatedWith(Names.named("RestHost")).to("http://127.0.0.1:3000");
      
      bind(TodoDao.class).to(TodoDaoRestProxy.class);
   }
}
