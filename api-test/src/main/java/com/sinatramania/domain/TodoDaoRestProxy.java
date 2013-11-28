package com.sinatramania.domain;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class TodoDaoRestProxy implements TodoDao {

   private static final String RESOURCE_NAME = "todos";

   private final WebResource webService;

   @Inject
   public TodoDaoRestProxy(@Named("RestHost") String host) {
      Client client = createClient();
      webService = client.resource(UriBuilder.fromUri(host).build());
   }

   private Client createClient() {
      ClientConfig config = new DefaultClientConfig();
      config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
      return Client.create(config);
   }

   @Override
   public List<Todo> list() {
      return restApi().get(new GenericType<List<Todo>>() {
      });
   }

   @Override
   public void store(Todo newTodo) {
      restApi().put(newTodo);
   }

   private Builder restApi() {
      return webService.path(RESOURCE_NAME).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
   }

}
