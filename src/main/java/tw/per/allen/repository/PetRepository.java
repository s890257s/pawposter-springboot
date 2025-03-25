package tw.per.allen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.per.allen.model.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
