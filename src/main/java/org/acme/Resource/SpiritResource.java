package org.acme.Resource;

import java.util.List;

import org.acme.Entity.Spirit;
import org.acme.Entity.Wine;
import org.acme.Repository.SpiritRepository;
import org.acme.Service.SpiritService;
import org.hibernate.search.mapper.orm.Search;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;



@Path("spirit")
@ApplicationScoped
public class SpiritResource {

        @Inject
    EntityManager entityManager;

    @Inject
    private SpiritService spiritservice;
    
    @Inject
    private SpiritRepository spiritRepository;

    @GET
    @Path("/{id}")
    public Response getSpriitbyId(@PathParam("id")long id){

        Spirit spirit = spiritRepository.findById(id);

        if(spirit != null){
            return Response.ok(spirit).build();

        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    
    }

    @GET
    @Path("allSpirits")
    public Response getAllSpirits(){

        List<Spirit> allSpirits= spiritRepository.findAllSpirits();
        return Response.ok(allSpirits).build();
    }

    @POST
    @Path("/addSpirit")
    public Response addSpirit( Spirit spirit){

        try {
      
            spiritservice.addSpirits(spirit);
        return Response.status(Response.Status.CREATED).entity("Spirit added successfully").build();
    } catch (Exception e) {
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error adding Spirit").build();
    }


    }

    @GET
    @Path("/search")
    public Response searchSpritssByName(@QueryParam("name") String name, @QueryParam("country") String country) {
        List<Spirit> spirit = Search.session(entityManager)
                .search(Spirit.class)
                .where(f -> f.bool()
                    .should(f.match().fields("name").matching(name))
                    .should(f.match().fields("country").matching(country)))
                .fetchHits(20); 

        if (spirit.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No spirits found with name: " + name).build();
        }

        return Response.ok(spirit).build();
    }

    @GET
    @Path("/searchSpiritbyAlc")
    public Response searchWinesByPrice(@QueryParam("alocholVolume") double alcohol) {
        List<Spirit> spirit = Search.session(entityManager)
                .search(Spirit.class)
                .where(f -> f.match().field("alcoholVolume").matching(alcohol))
                .fetchHits(20); 

        if (spirit.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No spirits found with AcoloholVolume from " + alcohol).build();
        }

        return Response.ok(spirit).build();
    }
    


    
}
