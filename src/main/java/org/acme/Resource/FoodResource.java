package org.acme.Resource;

import java.util.List;

import org.acme.Entity.Food;
import org.acme.Repository.FoodRepository;
import org.acme.Service.FoodService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;



@Path("food")
@ApplicationScoped
public class FoodResource {

    @Inject
    private FoodService foodService;
    
    @Inject
    private FoodRepository foodRepository;

    @GET
    @Path("/{id}")
    public Response getFoodId(@PathParam("id")long id){

        Food food = foodRepository.findById(id);

        if(food != null){
            return Response.ok(food).build();

        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    
    }

    @GET
    @Path("allFoods")
    public Response getAllFoods(){

        List<Food> allFoods= foodRepository.findAllFoods();
        return Response.ok(allFoods).build();
    }

    @POST
    @Path("/addFood")
    public Response addFood(Food food){

        try {
      
            foodService.addFoods(food);
        return Response.status(Response.Status.CREATED).entity("Food added successfully").build();
    } catch (Exception e) {
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error adding Food").build();
    }


    }
    


    
}
