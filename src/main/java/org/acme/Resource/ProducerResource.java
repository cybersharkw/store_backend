package org.acme.Resource;

import java.util.List;

import org.acme.Entity.Producer;
import org.acme.Repository.ProducerRepository;
import org.acme.Service.ProducerService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;



@Path("producer")
@ApplicationScoped
public class ProducerResource {

    @Inject
    private ProducerService producerService;
    
    @Inject
    private ProducerRepository producerRepository;

    @GET
    @Path("/{id}")
    public Response getProducerId(@PathParam("id")long id){

        Producer producer = producerRepository.findById(id);

        if(producer != null){
            return Response.ok(producer).build();

        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    
    }

    @GET
    @Path("allProducer")
    public Response getAllProducers(){

        List<Producer> allProducers= producerRepository.findAllProducers();
        return Response.ok(allProducers).build();
    }

    @POST
    @Path("/addProducer")
    public Response addProducer( Producer producer){

        try {
      
            producerService.addProducers(producer);
        return Response.status(Response.Status.CREATED).entity("Producer added successfully").build();
    } catch (Exception e) {
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error adding Producer").build();
    }


    }
    


    
}
