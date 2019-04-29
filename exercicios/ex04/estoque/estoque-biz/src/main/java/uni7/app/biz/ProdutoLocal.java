package uni7.app.biz;

import java.util.List;

import javax.ejb.Local;

import uni7.app.model.Produto;

@Local
public interface ProdutoLocal {

	public Produto criarProduto(Produto p);
	
	public Produto atualizarProduto(Produto p);
	
	public void deletarProduto(Produto p);
	
	public List<Produto> listarProdutos();
	
}
