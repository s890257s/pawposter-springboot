package tw.per.allen.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.per.allen.config.MemberHolder;
import tw.per.allen.model.dto.MemberDto;
import tw.per.allen.model.dto.PetDto;
import tw.per.allen.model.entity.PetVote;
import tw.per.allen.model.enums.VoteState;
import tw.per.allen.repository.PetRepository;
import tw.per.allen.repository.PetVoteRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private PetVoteRepository petVoteRepository;

	public List<PetDto> getAll() {
		List<PetDto> pets = petRepository.findAll().stream().map(PetDto::new).toList();

		MemberDto loggedInMebmer = MemberHolder.getMember();
		if (loggedInMebmer != null) {
			checkVote(loggedInMebmer.getMemberId(), pets);
		}

		return pets;
	}

	public List<PetDto> checkVote(Integer memberId, List<PetDto> pets) {
		List<PetVote> votes = petVoteRepository.findByMemberId(memberId);

		Map<Integer, VoteState> currentMebmerVoteMap = votes.stream().collect(Collectors.toMap(
				PetVote::getPetId,
				i -> VoteState.valueOf(i.getVoteType())));

		pets.forEach(p -> p.setVoteState(currentMebmerVoteMap.getOrDefault(p.getPetId(), VoteState.NOT_VOTE)));

		return pets;
	}
	
	
}
