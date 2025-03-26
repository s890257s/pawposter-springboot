package tw.per.allen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.per.allen.model.entity.PetVote;

public interface PetVoteRepository extends JpaRepository<PetVote, Integer> {
	List<PetVote> findByMemberId(Integer memberId);

	PetVote findByMemberIdAndPetId(Integer memberId, Integer petId);
}
