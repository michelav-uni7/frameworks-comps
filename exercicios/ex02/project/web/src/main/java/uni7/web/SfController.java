package uni7.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import uni7.biz.SfBean;

@SessionScoped
public class SfController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3254641407688088630L;
	
	@EJB
	private SfBean bean;
	
	public void incluir(String txt) {
		bean.incluir(txt);
	}

	public void remover(String txt) {
		bean.remover(txt);
	}
	
	public List<String> processar() {
		return bean.processar();
	}
	
	public List<String> listar() {
		return bean.listar();
	}
}
