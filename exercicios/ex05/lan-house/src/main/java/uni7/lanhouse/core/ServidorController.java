package uni7.lanhouse.core;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServidorController {
	
	@Autowired
	ServidorRepository repo;
	
	@GetMapping("/servidores")
	public List<Servidor> listarTodos() {
		return repo.findAll();
	}
	
	@GetMapping("/servidores/{id}")
	public Optional<Servidor> acharServidor(@PathVariable Integer id) {
		return repo.findById(id);
	}
	
	@PutMapping("/servidores")
	public ResponseEntity<Servidor> criarServidor(@RequestBody Servidor s) {
		repo.save(s);
		return new ResponseEntity<Servidor>(s, HttpStatus.CREATED);
	}

}
