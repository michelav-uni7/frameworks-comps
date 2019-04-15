package uni7.biz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class SfBean
 */
@Stateful
@LocalBean
public class SfBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2567413166302090178L;
	private Set<String> info = new HashSet<String>();

	/**
	 * Default constructor.
	 */
	public SfBean() {
	}

	public void incluir(String txt) {
		info.add(txt);
	}

	public void remover(String txt) {
		info.remove(txt);
	}

	public List<String> listar() {
		return set2List();
	}

	@Remove
	public List<String> processar() {
		System.out.println("Processando Lista do Bean");
		return set2List();
	}
    
    private List<String> set2List() {
    	List<String> lista = new ArrayList<String>();
    	info.forEach(dado -> lista.add(dado));
    	return lista;
    }
    
    @PostConstruct
    void postConstruct() {
    	System.out.println("SfBean " + this.toString() + " foi construido!");
    }
    
    @PreDestroy
    void preDestroy() {
    	System.out.println("SfBean " + this.toString() + " será destruido!");
    }

    @PrePassivate
    void prePassivate() {
    	System.out.println("SfBean " + this.toString() + " será passivado!");
    }
    
    @PostActivate
    void postActivate() {
    	System.out.println("SfBean " + this.toString() + " foi ativado!");
    }
}
