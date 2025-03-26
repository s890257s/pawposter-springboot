package tw.per.allen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.per.allen.model.dto.PetDto;
import tw.per.allen.model.enums.VoteState;
import tw.per.allen.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetService petService;

	@GetMapping("")
	public List<PetDto> getAll() {
		return petService.getAll();
	}

	@PutMapping("/vote/{action}")
	public VoteState vote(@PathVariable String action) {
		
		
		
		return null;
	}

}
