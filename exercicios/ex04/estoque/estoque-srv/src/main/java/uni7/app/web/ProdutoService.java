package uni7.app.web;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import uni7.app.biz.ProdutoLocal;
import uni7.app.model.Produto;

@RequestScoped
@Path("/produtos")
public class ProdutoService {

	@EJB
	private ProdutoLocal prdBean;

	@Context
	UriInfo info;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response criarProduto(Produto p) {
		Produto created = prdBean.criarProduto(p);
		URI uri = info.getBaseUriBuilder().path(ProdutoService.class).build(created);
		return Response.created(uri).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarProdutos() {
		List<Produto> produtos = prdBean.listarProdutos();
		return Response.ok(produtos).build();
	}	
}
