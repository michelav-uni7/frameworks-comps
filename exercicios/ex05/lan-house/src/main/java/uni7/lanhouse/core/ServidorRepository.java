package uni7.lanhouse.core;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServidorRepository extends JpaRepository<Servidor, Integer> {
	
	public List<Servidor> findAll();

}
