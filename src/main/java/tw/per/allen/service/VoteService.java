package tw.per.allen.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.per.allen.model.entity.PetVote;
import tw.per.allen.model.enums.VoteState;
import tw.per.allen.repository.PetVoteRepository;

@Service
public class VoteService {

	@Autowired
	private PetVoteRepository petVoteRepository;

	public VoteState vote(Integer memberId, Integer petId, VoteState voteState) {

		PetVote petVote = petVoteRepository.findByMemberIdAndPetId(memberId, petId);

		// 若找不到則新增
		if (petVote == null) {
			PetVote pv = new PetVote();
			pv.setMemberId(memberId);
			pv.setPetId(petId);
			pv.setVoteDate(new Date());
			pv.setVoteType(voteState.typeNumber);
			petVoteRepository.save(pv);
			return voteState;
		}

		// 若相等則刪除
		if (petVote.getVoteType() == voteState.typeNumber) {
			petVoteRepository.delete(petVote);
			return VoteState.NOT_VOTE;
		}

		// 剩下的則是不相等
		petVoteRepository.delete(petVote);
		

		return voteState;
	}
}
