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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servidores")
public class ServidorController {
	
	@Autowired
	ServidorRepository repo;
	
	@GetMapping
	public List<Servidor> listarTodos() {
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Servidor> acharServidor(@PathVariable Integer id) {
		return repo.findById(id);
	}
	
	@GetMapping("/serv")
	public Servidor acharServidorPorIp(@RequestParam("ip") String ip) {
		return repo.findByIp(ip);
	}
	
	
	@PutMapping
	public ResponseEntity<Servidor> criarServidor(@RequestBody Servidor s) {
		repo.save(s);
		return new ResponseEntity<Servidor>(s, HttpStatus.CREATED);
	}

}
