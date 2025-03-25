package tw.per.allen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.per.allen.model.dto.PetDto;
import tw.per.allen.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;

	public List<PetDto> getAll() {
		return petRepository.findAll().stream().map(PetDto::new).toList();
	}
}
