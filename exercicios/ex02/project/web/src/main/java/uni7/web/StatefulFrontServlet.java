package uni7.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StatefulFrontServlet
 */
public class StatefulFrontServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3265838446663528121L;
	@Inject
	private SfController controle;

    /**
     * Default constructor. 
     */
    public StatefulFrontServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao").toLowerCase();
		String info;
		PrintWriter writer = response.getWriter();
		StringBuffer buffer;
		List<String> lista;
		switch (acao) {
		case "incluir":
			info = request.getParameter("info").toLowerCase();
			controle.incluir(info);
			writer.append("Dado " + info + " incluído.");
			break;
		case "remover":
			info = request.getParameter("info").toLowerCase();
			controle.remover(info);
			writer.append("Dado " + info + " removido.");
			break;
		case "listar":
			lista = controle.listar();
			buffer = new StringBuffer("<UL>\n");
			lista.forEach(dado -> buffer.append("<LI>").append(dado).append("</LI>\n"));
			buffer.append("</UL>");
			writer.append("<BODY>");
			writer.append("<H2>Dados</H2>\n");
			writer.append(buffer.toString());
			writer.append("</BODY>");
			break;			
		case "processar":
			lista = controle.processar();
			buffer = new StringBuffer("<UL>\n");
			lista.forEach(dado -> buffer.append("<LI>").append(dado).append("</LI>\n"));
			buffer.append("</UL>");
			writer.append("<BODY>");
			writer.append("<H2>Itens Processados:</H2>\n");
			writer.append(buffer.toString());
			writer.append("</BODY>");
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
