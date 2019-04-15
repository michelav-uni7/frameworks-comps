package uni7.biz;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SlBean
 */
@Stateless
@LocalBean
public class SlBean {

    /**
     * Default constructor. 
     */
    public SlBean() {
        // TODO Auto-generated constructor stub
    }

    @PostConstruct
    void postConstruct() {
    	System.out.println("SlBean " + this.toString() + " foi construido!");
    }
    
    @PreDestroy
    void preDestroy() {
    	System.out.println("SlBean " + this.toString() + " será destruido!");
    }
    
    public String acao(String acao) {
    	return "Acao " + acao + " realizada! ";
    }
}
