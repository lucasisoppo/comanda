package com.lucasisoppo.comanda.resources;

import com.lucasisoppo.comanda.model.Produto;
import com.lucasisoppo.comanda.services.ProdutoService;
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

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    
    @Inject
    private ProdutoService service;
    
    @GET
    public Response findAll(){
        return Response.ok().build();
    }
    
    @POST
    public Response insert(Produto produto){
        return Response.status(Response.Status.CREATED).entity(service.insert(produto)).build();
    }
    
    @Path("{id}")
    public Response update(@PathParam("id")Long id, Produto produto){
        if(!id.equals(produto.getId())){
            throw new BadRequestException("ID do produto diferente");
        }
        return Response.ok(service.update(produto)).build();
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
