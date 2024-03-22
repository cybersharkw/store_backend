package org.acme.Resource;

import java.util.List;

import org.acme.Entity.Wine;
import org.acme.Entity.Enum.WineType;
import org.acme.Repository.WineRepository;
import org.acme.Service.WineService;
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



@Path("wine")
@ApplicationScoped
public class WineResource {

        @Inject
    EntityManager entityManager;


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

    @GET
    @Path("/search")
    public Response searchWinesByName(@QueryParam("name") String name, @QueryParam("country") String country) {
        List<Wine> wine = Search.session(entityManager)
                .search(Wine.class)
                .where(f -> f.bool()
                    .should(f.match().fields("name").matching(name))
                    .should(f.match().fields("country").matching(country)))
                .fetchHits(20); 

        if (wine.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Wines found with name: " + name).build();
        }

        return Response.ok(wine).build();
    }
    
    @GET
    @Path("/searchWinebyPrice")
    public Response searchWinesByPrice(@QueryParam("PriceFrom") double priceFrom, @QueryParam("PriceTill") double priceTill) {
        List<Wine> wine = Search.session(entityManager)
                .search(Wine.class)
                .where(f -> f.range().field("price").between(priceFrom, priceTill))
                .fetchHits(20); 

        if (wine.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Wines found with price from: " +  priceFrom + "till: " + priceTill ).build();
        }

        return Response.ok(wine).build();
    }

    @GET
    @Path("/searchWineCategories")
    public Response searchWinesByCategorie(@QueryParam("categorie") WineType wineType) {
        List<Wine> wine = Search.session(entityManager)
                .search(Wine.class)
                .where(f -> f.match().fields("categorie").matching(wineType))
                .fetchHits(20); 

        if (wine.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Wine found with categpry: " + wineType).build();
        }

        return Response.ok(wine).build();
    }


    


    
}
