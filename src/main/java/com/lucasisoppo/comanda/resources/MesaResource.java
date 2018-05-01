package com.lucasisoppo.comanda.resources;

import com.lucasisoppo.comanda.model.Mesa;
import com.lucasisoppo.comanda.services.MesaService;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("mesas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MesaResource {
    
    @Inject
    private MesaService service;
    
    @GET
    public Response findAll(){
        return Response.ok().build();
    }
    
    @POST
    public Response insert(Mesa mesa){
        return Response.status(Response.Status.CREATED).entity(service.insert(mesa)).build();
    }
    
    @Path("{id}")
    public Response update(@PathParam("id")Long id, Mesa mesa){
        if(!id.equals(mesa.getId())){
            throw new BadRequestException("ID da mesa diferente");
        }
        return Response.ok(service.update(mesa)).build();
    }
    
    @Path("{id}")
    public Response remove(@PathParam("id")Long id){
        service.remove(id);
        return Response.noContent().build();
    }
    
    @Path("{id}")
    public Response findById(@PathParam("id")Long id){
        return Response.ok(service.findById(id)).build();
    }    
}
