package com.rhdevelopers.books;

import java.net.URI;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

public interface PoiRemoteService {

    @GET
    @Path("ws/info")
    public Response getInfo();

    @GET
    @Path("poi/find/all")
    public Response getAllData();

    static PoiRemoteService createRestClient(String resourceEndpoint) {
        try {
            return RestClientBuilder.newBuilder()
                .baseUri(new URI(resourceEndpoint))
                .build(PoiRemoteService.class);
        } catch (Exception e) {
            throw new RuntimeException("rest client creation failed for resource endpoint "+resourceEndpoint,e);
        }
    }

}
