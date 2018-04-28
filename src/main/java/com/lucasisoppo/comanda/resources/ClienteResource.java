package com.lucasisoppo.pedidos.resources;

import com.lucasisoppo.pedidos.model.Cliente;
import com.lucasisoppo.pedidos.services.ClienteService;
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

@Path("clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {
    
    @Inject
    private ClienteService service;
    
    @GET
    public Response findAll(){
        return Response.ok().build();
    }
    
    @POST
    public Response insert(Cliente cliente){
        return Response.status(Response.Status.CREATED).entity(service.insert(cliente)).build();
    }
    
    @Path("{id}")
    public Response update(@PathParam("id")Long id, Cliente cliente){
        if(!id.equals(cliente.getId())){
            throw new BadRequestException("ID do cliente diferente");
        }
        return Response.ok(service.update(cliente)).build();
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
