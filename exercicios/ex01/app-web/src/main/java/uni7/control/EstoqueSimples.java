package uni7.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstoqueSimples implements Estoque {

	@Override
	public List<String> produtos() {
		return List.of("Arroz", "Macarrao", "Acucar", "Milho");
	}

}
