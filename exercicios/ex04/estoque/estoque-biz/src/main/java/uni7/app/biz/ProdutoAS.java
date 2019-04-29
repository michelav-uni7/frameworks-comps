package uni7.app.biz;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import uni7.app.model.Produto;

@Stateless
public class ProdutoAS implements ProdutoLocal {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Produto criarProduto(Produto p) {
		System.out.println("Criando produto...\n");
		em.persist(p);
		return p;
	}

	@Override
	public Produto atualizarProduto(Produto p) {
		System.out.println("Atualizando produto...");
		return null;
	}

	@Override
	public void deletarProduto(Produto p) {
		System.out.println("Deletando produto...");
	}

	@Override
	public List<Produto> listarProdutos() {
		System.out.println("Listando produtos...");
		Query todos = em.createNamedQuery("Produto.ListarTodos", Produto.class);
		List<Produto> produtos =  todos.getResultList();
		return produtos;
	}
}
