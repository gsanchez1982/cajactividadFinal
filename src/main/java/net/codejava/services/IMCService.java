package net.codejava.services;

import net.codejava.entity.IMC;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.codejava.repositories.IMCRepository;

@Service
@Transactional
public class IMCService {

	@Autowired
	private IMCRepository repo;
	
	public List<IMC> listAll() {
		return repo.findAll();
	}
	
	public void save(IMC listIMC) {
		repo.save(listIMC);
	}
	
	public IMC get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
