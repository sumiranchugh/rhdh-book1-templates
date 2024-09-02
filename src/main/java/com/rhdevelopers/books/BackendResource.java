package com.rhdevelopers.books;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import com.rhdevelopers.books.BackendRegistry.Backend;

@Path("/backend")
public class BackendResource {

    @Inject
    BackendRegistry backendRegistry;

    @GET
    @Path("list")
    public List<Backend> getAllBackends() {
        return backendRegistry.getAllRegisteredBackends()
            .entrySet().stream()
            .map(e -> e.getValue().backendInfo())
            .collect(Collectors.toList());
    }

    @GET
    @Path("unregister/{backendId}")
    public Response unregisterBackend(@PathParam("backendId") String backendId) {
        backendRegistry.unregister(backendId, "");
        return Response.noContent().build();
    }

    @GET
    @Path("register/{backendId}")
    public Response registerBackend(@PathParam("backendId") String backendId, @QueryParam("endpoint") String endpoint) {
        backendRegistry.register(backendId, endpoint);
        return Response.noContent().build();
    }
   
}
