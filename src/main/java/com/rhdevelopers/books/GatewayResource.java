package com.rhdevelopers.books;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import com.rhdevelopers.books.k8s.ServiceWatcher;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.openshift.client.OpenShiftClient;
import io.quarkus.logging.Log;
import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;

@Startup
@Path("/ws/data")
public class GatewayResource {

    @Inject
    OpenShiftClient k8sClient;

    @Inject
    BackendRegistry backendRegistry;

    @Inject
    ServiceWatcher serviceWatcher;

    @PostConstruct
    void init() {
        try {
            var namespace = k8sClient.getNamespace();
            Log.debugv("watching services via k8s API in namespace: {0}",namespace);
            k8sClient.services().inNamespace(namespace).watch(serviceWatcher);
        } catch(KubernetesClientException exc) {
            Log.error("failed to start watching services via k8s API which is most likely due to missing permissions");
            Log.error(exc.getMessage());
        }
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PoiRecord> findAll(@QueryParam("service") String backendId) {
        var backendProxy = backendRegistry.getBackendForId(backendId);
        if (backendProxy == null) {
            Log.errorv("no backend with id {0} found in registry",backendId);
            return null;
        }
        return backendProxy.restClient().getAllData().readEntity(new GenericType<List<PoiRecord>>() {});
    }

}