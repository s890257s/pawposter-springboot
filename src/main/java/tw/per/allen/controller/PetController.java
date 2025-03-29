package tw.per.allen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.per.allen.config.MemberHolder;
import tw.per.allen.model.dto.PetDto;
import tw.per.allen.model.enums.VoteState;
import tw.per.allen.service.PetService;
import tw.per.allen.service.VoteService;

@RestController
@RequestMapping("/api/pets")
public class PetController {

	@Autowired
	private PetService petService;

	@Autowired
	private VoteService voteService;

	@GetMapping("")
	public List<PetDto> getAll() {
		return petService.getAll();
	}

	@PutMapping("/{petId}/vote")
	public VoteState vote(@PathVariable Integer petId, @RequestParam String action) {

		VoteState vote = voteService.vote(MemberHolder.getMember().getMemberId(), petId, VoteState.valueOf(action));

		return vote;
	}
	
	

}
