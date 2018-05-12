package com.lucasisoppo.comanda.resources;

import com.lucasisoppo.comanda.model.Produto;
import com.lucasisoppo.comanda.services.ProdutoService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    
    @Inject
    private ProdutoService service;
    
    @GET
    public Response findAll(@QueryParam("filtro") String filtro){
         return Response.ok(service.findAll(filtro)).build();
    }
    
    @POST
    public Response insert(Produto produto){
        return Response.status(Response.Status.CREATED).entity(service.insert(produto)).build();
    }
    
    @PUT
    @Path("{id: \\d+}")
    public Response update(@PathParam("id")Long id, Produto produto){
        Produto prod = service.findById(id);
        if (prod == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }        
        if(!id.equals(produto.getId())){
            throw new BadRequestException("ID do produto diferente");
        }
        return Response.ok(service.update(produto)).build();
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public Response remove(@PathParam("id")Long id){
        service.remove(id);
        return Response.noContent().build();
    }
    
    @GET
    @Path("{id: \\d+}")
    @Produces({ MediaType.APPLICATION_JSON, 
        MediaType.APPLICATION_XML})
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }
}
