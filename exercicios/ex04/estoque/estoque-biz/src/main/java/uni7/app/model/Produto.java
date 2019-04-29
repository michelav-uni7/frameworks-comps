package uni7.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "produto")
@XmlRootElement(name = "produto")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "Produto.ListarTodos", 
			query = "Select p from Produto p")
public class Produto {

	private Integer id;

	private String nome;

	private Integer quantidade;

	private Double valor;
	
	@Transient
	@XmlTransient
	private StringBuffer buf;

	@Id
	@SequenceGenerator(name="PRODUTO_ID_GENERATOR", sequenceName="PRODUTO_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUTO_ID_GENERATOR")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String toString() {
		if(buf == null) {
			buf = new StringBuffer("Produto => (");
			buf.append(nome).append(", Id: ").append(id);
			buf.append(", Qtde: ").append(quantidade);
			buf.append(", Valor: ").append(valor).append(")");
		}
		return buf.toString();
	} 

}
