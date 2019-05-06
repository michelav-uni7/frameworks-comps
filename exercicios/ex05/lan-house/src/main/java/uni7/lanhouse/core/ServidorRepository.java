package uni7.lanhouse.core;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServidorRepository extends JpaRepository<Servidor, Integer> {
	
	public List<Servidor> findAll();
	
	public Servidor findByIp(String ip);
	
	public List<Servidor> findByGrupo(String grupo);

}
