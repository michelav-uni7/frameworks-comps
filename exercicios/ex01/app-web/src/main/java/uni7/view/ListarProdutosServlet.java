package uni7.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uni7.control.Estoque;

/**
 * Servlet implementation class ListarProdutosServlet
 */
@WebServlet("/listarProdutos")
public class ListarProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject private Estoque meuEstoque;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProdutosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> produtos = meuEstoque.produtos();
		StringBuffer buffer = new StringBuffer("<UL>\n");
		produtos.forEach(produto -> buffer.append("<LI>").append(produto).append("</LI>\n"));
		buffer.append("</UL>");
		PrintWriter writer = response.getWriter();
		writer.append("<BODY>");
		writer.append("<H2>Produtos</H2>\n");
		writer.append(buffer.toString());
		writer.append("</BODY>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
