package org.acme.Resource;

import java.util.List;

import org.acme.Entity.Wine;
import org.acme.Repository.WineRepository;
import org.acme.Service.WineService;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;



@Path("wine")
@ApplicationScoped
public class WineResource {

    @Inject
    private WineService wineService;
    
    @Inject
    private WineRepository wineRepository;

    @GET
    @Path("/{id}")
    public Response getWinebyId(@PathParam("id")long id){

        Wine wine = wineRepository.findById(id);

        if(wine != null){
            return Response.ok(wine).build();

        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    
    }

    @GET
    @Path("allWine")
    public Response getAllWine(){

        List<Wine> allWine = wineRepository.findAllWines();
        return Response.ok(allWine).build();
    }

    @POST
    @Path("/addWine")
    public Response addWine( Wine wine){

        try {
      
        wineService.addWine(wine);
        return Response.status(Response.Status.CREATED).entity("Wine added successfully").build();
    } catch (Exception e) {
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error adding wine").build();
    }


    }
    


    
}
