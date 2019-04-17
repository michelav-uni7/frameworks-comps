package uni7.web.resources;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/pedido")
public class PedidoService {

	@Inject
	private JMSContext context;

	@Resource(lookup = "java:/jms/queue/pQueue")
	private Queue pQueue;

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_HTML)
	public Response criarPedido(String pedido) {
		System.out.println(pedido);
		context.createProducer().send(pQueue, pedido);
		System.out.println("Pedido enviado!");
		return Response.ok().build();
	}
}
