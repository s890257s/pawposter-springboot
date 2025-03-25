package tw.per.allen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.per.allen.model.entity.PetVote;

public interface PetVoteRepository extends JpaRepository<PetVote, Integer> {

}
