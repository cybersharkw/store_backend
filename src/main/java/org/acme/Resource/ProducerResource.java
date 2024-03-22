package org.acme.Resource;

import java.util.List;

import org.acme.Entity.Producer;
import org.acme.Repository.ProducerRepository;
import org.acme.Service.ProducerService;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;



@Path("producer")
@ApplicationScoped
public class ProducerResource {

    @Inject
    EntityManager entityManager;

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

    @GET
    @Path("/search")
    public Response searchProducersByName(@QueryParam("name") String name, @QueryParam("country") String country) {
        List<Producer> producers = Search.session(entityManager)
                .search(Producer.class)
                .where(f -> f.bool()
                    .should(f.match().fields("name").matching(name))
                    .should(f.match().fields("country").matching(country)))
                .fetchHits(20); 

        if (producers.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No producers found with name: " + name).build();
        }

        return Response.ok(producers).build();
    }

    @GET
    @Path("/countByCountry")
    public Response countByCountry(@QueryParam("country") String country) {
        try {
            SearchSession searchSession = Search.session(entityManager);
            long totalHitCount = searchSession.search(Producer.class)
                    .where(f -> f.match().field("country").matching(country))
                    .fetchTotalHitCount();
    
       
            return Response.ok(totalHitCount).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred").build();
        }
    }


}
    


    
